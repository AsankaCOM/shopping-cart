package com.cart.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    BOOK_NOT_FOUND("Book not found"),
    BOOK_ALREADY_EXIST("Book already exist in the database");

    private final String description;

    ErrorCode(String description) {
        this.description = description;
    }
}
