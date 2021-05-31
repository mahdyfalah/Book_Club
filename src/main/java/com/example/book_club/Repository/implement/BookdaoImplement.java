package com.example.book_club.Repository.implement;

import com.example.book_club.Repository.bookdao;
import com.example.book_club.Repository.userdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.awt.print.Book;

@Repository
public class BookdaoImplement extends JdbcDaoSupport implements bookdao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public void insert(Book book) {
        ///Insetr
    }

    @Override
    public void delete(Book book) {
        //delete
    }
}
