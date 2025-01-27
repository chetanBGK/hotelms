package com.hotelservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionbHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> handleResourceNotFoundException(ResourceNotFoundException ex)
    {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setMessage(ex.getMessage());
        apiResponse.setStatus(false);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);

    }
}
