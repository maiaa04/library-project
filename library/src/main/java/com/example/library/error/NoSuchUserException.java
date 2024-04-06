package com.example.library.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoSuchUserException extends RuntimeException{
    private NoSuchUserException(String message) {
        super(message);
    }

    public static ResponseStatusException create(){
        NoSuchUserException exception = new NoSuchUserException("User does not exist.");
        return new ResponseStatusException(HttpStatus.NO_CONTENT, exception.getMessage(), exception);
    }
}
