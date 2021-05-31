package com.example.book_club.Repository.implement;

import com.example.book_club.Repository.userdao;
import com.example.book_club.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.transaction.Transactional;

@Repository
public class UserdaoImplement extends JdbcDaoSupport implements userdao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }
    @Override
    public void insert(User cus) {

        String sql = "INSERT INTO user " +
                "(user_name, password,email,register_date) VALUES (?, ?,?,?)" ;
        getJdbcTemplate().update(sql, new Object[]{
                cus.getUser_name(), cus.getPassword(),cus.getEmail(),cus.getRegister_date()
        });

    }
}
