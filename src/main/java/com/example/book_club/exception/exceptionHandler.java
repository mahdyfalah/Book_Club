package com.example.book_club.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class exceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> handle(RuntimeException e){
        DefaultException defaultException = new DefaultException(new Date(), e.getMessage());
        return new ResponseEntity(defaultException, HttpStatus.NOT_FOUND);
    }
}
