package com.hotelms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionbHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(ex.getMessage());
        apiResponse.setSuccess(false);
        apiResponse.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
    }
}
