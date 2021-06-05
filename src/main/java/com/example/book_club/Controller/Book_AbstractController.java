package com.example.book_club.Controller;

import com.example.book_club.model.Book;
import com.example.book_club.model.Book_Abstract;
import com.example.book_club.repository.implement.Book_AbstractDaoImplement;
import com.example.book_club.response.MessageProperties;
import com.example.book_club.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class Book_AbstractController {

    private Book_AbstractDaoImplement service;
    private ResponseHandler responseHandler;

    public Book_AbstractController(Book_AbstractDaoImplement service, ResponseHandler responseHandler) {
        this.service = service;
        this.responseHandler = responseHandler;
    }

    @GetMapping("/getbook_abstracts")
    public ResponseEntity<?> getBook_Abstract(){
        List<Book_Abstract> list = service.list();
        return responseHandler.successProvider(HttpStatus.OK, MessageProperties.BOOKS_RECIEVED_MSG, list);
    }

    @PostMapping("/addbook_abstract")
    public ResponseEntity<?> addBook_Abstract(@RequestBody Book_Abstract book_abstract){
        int i = service.create(book_abstract);
        book_abstract.setBook_abstract_id(i);
        return responseHandler.successProvider(HttpStatus.CREATED, MessageProperties.BOOKS_RECIEVED_MSG, book_abstract);
    }

}
