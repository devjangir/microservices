package com.jangir.loanservice.exception;

public class LoanAlreadyExistException extends RuntimeException {
    public LoanAlreadyExistException(String message) {
        super(message);
    }
}
