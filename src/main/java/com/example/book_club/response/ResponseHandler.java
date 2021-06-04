package com.example.book_club.response;

import com.example.book_club.payload.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface ResponseHandler {

    ResponseEntity<SuccessResponse> successProvider(HttpStatus httpStatus, MessageProperties messageProperties, Object... data);

}
