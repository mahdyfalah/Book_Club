package dao;

import model.Book_Abstract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Book_AbstractJdbcDAO implements DAO<Book_Abstract>{

    private static Logger log = LoggerFactory.getLogger(Book_AbstractJdbcDAO.class);
    private JdbcTemplate jdbcTemplate;

    RowMapper<Book_Abstract> rowMapper = (rs, rowNum) ->{
        Book_Abstract book_abstract = new Book_Abstract();
        book_abstract.setDetails(rs.getString("details"));
        book_abstract.setParental_advisory(rs.getString("parental_advisory"));
        return book_abstract;
    };

    public Book_AbstractJdbcDAO(JdbcTemplate jdbcTemplate){ this.jdbcTemplate = jdbcTemplate; }

    @Override
    public List<Book_Abstract> list() {
        String sql = "SELECT details, parental_advisory FROM book_abstract";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void create(Book_Abstract book_abstract) {
        String sql = "INSERT INTO user(user_name, password, email) VALUES (?, ?, ?)";
        int insert = jdbcTemplate.update(sql, book_abstract.getDetails(), book_abstract.getParental_advisory());
        if(insert == 1) {
            log.info("New Abstract Created" + book_abstract.getBook_abstract_id());
        }
    }

    @Override
    public Optional get(int id) {
        String sql = "SELECT details, parental_advisory FROM book_abstract WHERE book_abstract_id = ?";
        Book_Abstract book_abstract = null;
        try {
            book_abstract = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        }catch (DataAccessException ex) {
            log.info("Abstract not found: " + id);
        }
        return Optional.ofNullable(book_abstract);
    }

    @Override
    public void update(Book_Abstract book_abstract, int id) {
        String sql = "UPDATE book_abstract SET details = ?, parental_advisory = ? WHERE book_abstract_id = ?";
        int update = jdbcTemplate.update(sql, book_abstract.getDetails(), book_abstract.getParental_advisory(), id);
        if(update == 1) {
            log.info("Abstract Updated: " + book_abstract.getBook_abstract_id());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM book_abstract WHERE book_abstract_id = ?";
        int delete = jdbcTemplate.update(sql,id);
        if(delete == 1) {
            log.info("User Deleted: " + id);
        }
    }
}
