package com.example.book_club.exception;

import java.util.Date;

public class DefaultException {

    private Date date;
    private String message;

    public DefaultException(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }
}
