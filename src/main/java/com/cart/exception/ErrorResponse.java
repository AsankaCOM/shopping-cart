package com.cart.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse {
    LocalDateTime timestamp;
    String message;
    ErrorCode errorCode;
    String details;

    public ErrorResponse(LocalDateTime timestamp,
                         String message,
                         ErrorCode errorCode,
                         String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.errorCode = errorCode;
        this.details = details;
    }
}
