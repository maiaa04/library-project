package com.example.library.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoSuchLoanException extends RuntimeException{
    private NoSuchLoanException(String message) {
        super(message);
    }

    public static ResponseStatusException create(){
        NoSuchLoanException exception = new NoSuchLoanException("Loan does not exist.");
        return new ResponseStatusException(HttpStatus.NO_CONTENT, exception.getMessage(), exception);
    }
}