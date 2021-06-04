package com.example.book_club.response;

import com.example.book_club.payload.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ResponseHandlerImpl implements ResponseHandler{

    @Override
    public ResponseEntity<SuccessResponse> successProvider(HttpStatus httpStatus, MessageProperties messageProperties, Object... data) {
        SuccessResponse  success =  new SuccessResponse(
                httpStatus.value(),
                messageProperties.name(),
                LocalDateTime.now(),
                data
        );
         return new ResponseEntity<SuccessResponse>(success, httpStatus);
    }
}
