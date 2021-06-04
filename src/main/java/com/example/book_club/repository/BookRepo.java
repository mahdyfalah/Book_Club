package com.example.book_club.repository;

import com.example.book_club.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {}
