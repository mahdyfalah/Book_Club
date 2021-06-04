package com.example.book_club.repository;
import com.example.book_club.model.Book;
public interface bookdao {

    void insert(Book book);
    void delete(Book book);
}
