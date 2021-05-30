package dao;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserJdbcDAO implements DAO<User>{

    private static final Logger log = LoggerFactory.getLogger(UserJdbcDAO.class);
    private JdbcTemplate jdbcTemplate;

    public UserJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    RowMapper<User> rowMapper = (rs, rowNum) ->{
        User user = new User();
        user.setUser_name(rs.getString("user_name"));
        user.setEmail(rs.getString("email"));
        return user;
    };

    @Override
    public List<User> list() {
        String sql = "SELECT user_name, email FROM user";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void create(User user) {
        String sql = "INSERT INTO user(user_name, password, email) VALUES (?, ?, ?)";
        int insert = jdbcTemplate.update(sql, user.getUser_name(), user.getEmail());
        if(insert == 1) {
            log.info("New User Created: " + user.getUser_name());
        }
    }

    @Override
    public Optional<User> get(int id) {
        String sql = "SELECT user_name, email FROM user WHERE user_id = ?";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        }catch (DataAccessException ex) {
            log.info("Course not found: " + id);
        }
        return Optional.ofNullable(user);
    }

    @Override
    public void update(User user, int id) {
        String sql = "UPDATE user SET user_name = ?, email = ?, password = ? WHERE user_id = ?";
        int update = jdbcTemplate.update(sql, user.getUser_name(), user.getEmail(), user.getPassword(),id);
        if(update == 1) {
            log.info("Course Updated: " + user.getUser_name());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM user WHERE user_id = ?";
        int delete = jdbcTemplate.update(sql,id);
        if(delete == 1) {
            log.info("User Deleted: " + id);
        }
    }
}
