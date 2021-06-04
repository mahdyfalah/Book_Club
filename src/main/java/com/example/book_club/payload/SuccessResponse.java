package com.example.book_club.payload;

import java.time.LocalDateTime;

public class SuccessResponse extends DefaultResponse{

    private Object data;

    public SuccessResponse(int statusCode, String message, LocalDateTime timeStamp, Object data) {
        super(statusCode, message, timeStamp);
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
