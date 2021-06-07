package com.example.book_club.Controller;


import com.example.book_club.model.Book;
import com.example.book_club.repository.implement.BookDaoImplement;
import com.example.book_club.response.MessageProperties;
import com.example.book_club.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
public class BookController {


//    private UserdaoImplement implement;
    private BookDaoImplement service;
    private ResponseHandler responseHandler;

    public BookController(BookDaoImplement service, ResponseHandler responseHandler) {
        this.service = service;
        this.responseHandler = responseHandler;
    }


    @PostMapping("/addbook")
    public ResponseEntity<?> addBook(@RequestBody Book book){
        int i = service.create(book);
        book.setBook_id(i);
        return responseHandler.successProvider(HttpStatus.CREATED, MessageProperties.BOOKS_RECIEVED_MSG, book);
    }

    @GetMapping("/add")
    public String add(Model model) {
        Book book = new Book();
        model.addAttribute("Book", book);
        return "AddBook";
    }

    @PostMapping("/saveBook")
    public String saveProduct(@ModelAttribute("book") Book book) {
        service.create(book);
        return "redirect:/add";
    }

    @GetMapping("/ListOfBooks")
    public String viewListOfProducts(Model model) {
        model.addAttribute("listBooks", service.list());
        return "Books";
    }

    @GetMapping("/getbooks")
    public ResponseEntity<?> getBooks(){
        List<Book> list = service.list();
        return responseHandler.successProvider(HttpStatus.OK, MessageProperties.BOOKS_RECIEVED_MSG, list);
    }

    @GetMapping("/getbookbyid/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Integer id){
        Book book = service.get(id).orElseThrow(() -> new RuntimeException() );
        return responseHandler.successProvider(HttpStatus.OK, MessageProperties.BOOKS_RECIEVED_MSG, book);
    }


    @GetMapping("/getbookbytitle/{title}")
    public ResponseEntity<?> getBookByTitle(@PathVariable("title") String title){
        Map<String, Object> map = service.getByTitle(title);
        return responseHandler.successProvider(HttpStatus.OK, MessageProperties.BOOKS_RECIEVED_MSG, map);
    }

    @PutMapping("/updatebook/{id}")
    public ResponseEntity<?> updateBook(@RequestBody Book book, @PathVariable Integer id){
        book = service.update(book, id).orElseThrow(() -> new RuntimeException());
        return responseHandler.successProvider(HttpStatus.OK, MessageProperties.BOOKS_RECIEVED_MSG, book);
    }

    @DeleteMapping("/deletebook/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer id){
        service.delete(id);
        return responseHandler.successProvider(HttpStatus.OK, MessageProperties.BOOKS_RECIEVED_MSG);
    }


//    @GetMapping("/addbook")
//    public String addbook(Model model, Book book) {
//        model.addAttribute("Book", book);
//
//
//
////        User user = new User();
////
////        user.setEmail("test11");
////        user.setPassword("ye1");
////        user.setUser_name("test1");
////        user.setRegister_date("test");
////        bookdaoImplement.insert(user);
//
//        return "AddBook";
//    }

//    @PostMapping("/adduser")
//    public String addProduct(@RequestBody User user) {
//
////        User user = new User();
////
////        user.setEmail("test11");
////        user.setPassword("ye1");
////        user.setUser_name("test1");
////        user.setRegister_date("test");
//
//
//        implement.insert(user);
//
//        return "Adduser";
//    }


}