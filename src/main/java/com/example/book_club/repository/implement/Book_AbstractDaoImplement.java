package com.example.book_club.repository.implement;

import com.example.book_club.model.Book_Abstract;
import com.example.book_club.repository.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
public class Book_AbstractDaoImplement extends JdbcDaoSupport implements DAO<Book_Abstract> {

    @Autowired
    DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public List<Book_Abstract> list() {
        String sql = "Select * From book_abstract";
        List<Book_Abstract> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book_Abstract.class));
        return list;
    }

    @Override
    public int create(Book_Abstract book_abstract) {
        String sql = "INSERT INTO book_abstract (details, parental_advisory) VALUES (?, ?)" ;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"book_abstract_id"});
            ps.setString(1, book_abstract.getDetails());
            ps.setString(2, book_abstract.getParental_advisory());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public Optional<Book_Abstract> get(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Book_Abstract> update(Book_Abstract book_abstract, int id) {
        return Optional.empty();
    }

    @Override
    public void delete(int id) {

    }
}
