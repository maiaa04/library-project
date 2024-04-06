package com.example.library.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class WrongPasswordException  extends RuntimeException{
    private WrongPasswordException(String message) {
        super(message);
    }

    public static ResponseStatusException create(){
        WrongPasswordException exception = new WrongPasswordException("Wrong username or password.");
        return new ResponseStatusException(HttpStatus.CONFLICT, exception.getMessage(), exception);
    }
}