package com.example.book_club.repository;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    List<T> list();

    int create(T t);

    Optional<T> get(Integer id);

    Optional<T> update(T t, int id);

    void delete(int id);
}