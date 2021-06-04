package com.example.book_club.response;

public enum MessageProperties {
    BOOKS_RECIEVED_MSG("BOOK REVICED")


    ;


    private final String name;

    MessageProperties(String name) {
        this.name = name;
    }


}
