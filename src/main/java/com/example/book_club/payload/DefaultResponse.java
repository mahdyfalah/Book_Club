package com.example.book_club.payload;

import java.time.LocalDateTime;

public class DefaultResponse {
    private int statusCode;
    private String message;
    private LocalDateTime timeStamp;

    public DefaultResponse(int statusCode, String message, LocalDateTime timeStamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
