package com.example.library.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoSuchBookException extends RuntimeException{
    private NoSuchBookException(String message) {
        super(message);
    }

    public static ResponseStatusException create(){
        NoSuchBookException exception = new NoSuchBookException("Book does not exist.");
        return new ResponseStatusException(HttpStatus.NO_CONTENT, exception.getMessage(), exception);
    }
}