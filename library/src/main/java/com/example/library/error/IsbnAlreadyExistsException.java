package com.example.library.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class IsbnAlreadyExistsException extends RuntimeException{
    private IsbnAlreadyExistsException(String message) {
        super(message);
    }

    public static ResponseStatusException create(String isbn){
        IsbnAlreadyExistsException exception = new IsbnAlreadyExistsException(String.format("Book with username: %s already exists.", isbn));
        return new ResponseStatusException(HttpStatus.CONFLICT, exception.getMessage(), exception);
    }
}