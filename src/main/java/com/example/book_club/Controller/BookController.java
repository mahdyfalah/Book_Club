package com.example.book_club.Controller;


import com.example.book_club.Repository.implement.BookdaoImplement;
import com.example.book_club.Repository.implement.UserdaoImplement;
import com.example.book_club.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

@Controller
public class BookController {


    private  UserdaoImplement implement;
    private BookdaoImplement bookdaoImplement;

    public BookController(UserdaoImplement service,BookdaoImplement bookdaoImplement) {
        this.implement = service;
        this.bookdaoImplement = bookdaoImplement;
    }

 


    @GetMapping("/addbook")
    public String addbook(Model model, Book book) {
        model.addAttribute("Book", book);



//        User user = new User();
//
//        user.setEmail("test11");
//        user.setPassword("ye1");
//        user.setUser_name("test1");
//        user.setRegister_date("test");
//        bookdaoImplement.insert(user);

        return "AddBook";
    }
    @GetMapping("/adduser")
    public String addProduct() {

        User user = new User();

        user.setEmail("test11");
        user.setPassword("ye1");
        user.setUser_name("test1");
        user.setRegister_date("test");
        implement.insert(user);

        return "Adduser";
    }


}
