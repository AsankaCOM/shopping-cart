package com.cart.exception;

import lombok.Getter;

@Getter
public class BookNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;

    public BookNotFoundException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }
}
