package com.example.book_club.repository.implement;

import com.example.book_club.repository.DAO;
import com.example.book_club.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Repository
public class BookDaoImplement extends JdbcDaoSupport implements DAO<Book> {

    @Autowired
    DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    RowMapper<Book> rowMapper = (rs, rowNum) -> {
        Book book = new Book();
        book.setBook_id(rs.getInt("book_id"));
        book.setIsbn(rs.getString("isbn"));
        book.setTitle(rs.getString("title"));
        book.setPublisher(rs.getString("publisher"));
        return book;
    };

    RowMapper<Book> rowMapperTitle = (rs, rowNum) -> {
        Book book = new Book();
        book.setIsbn(rs.getString("isbn"));
        book.setTitle(rs.getString("title"));
        return book;
    };


    @Override
    public List<Book> list() {
        String sql = "Select * From book";
        List<Book> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
        return list;
    }

    @Override
    public int create(Book book) {
        String sql = "INSERT INTO book (isbn, title, publisher) VALUES (?, ?, ?)" ;
//        getJdbcTemplate().update(sql, book.getIsbn(), book.getTitle(), book.getPublisher(), keyHolder);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"book_id"});
            ps.setString(1, book.getIsbn());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getPublisher());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public Optional<Book> get(Integer id) {
        String sql = "SELECT * FROM Book b WHERE b.book_id = ?";
        Book book = null;
        book =  jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);

        return Optional.ofNullable(book);
    }

    public Map<String, Object> getByTitle(String title) {
        String sql = "SELECT isbn FROM Book b WHERE b.title = ?";


        Map<String, Object> query = jdbcTemplate.queryForMap(sql, new Object[]{title});


        return query;
    }

    @Override
    public Optional<Book> update(Book book, int id) {
        String sql = "UPDATE book SET isbn = ?, title = ?, publisher = ? WHERE book_id = ?" ;
        getJdbcTemplate().update(sql, book.getIsbn(), book.getTitle(), book.getPublisher(), id);
        return get(id);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM book WHERE book_id = ?";
        getJdbcTemplate().update(sql, id);
    }
}
