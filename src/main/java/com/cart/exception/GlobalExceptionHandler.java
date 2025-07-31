package com.cart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<?> handleException(BookNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),
                exception.getMessage(),
                exception.getErrorCode(),
                "The requested book could not be found in the database");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
