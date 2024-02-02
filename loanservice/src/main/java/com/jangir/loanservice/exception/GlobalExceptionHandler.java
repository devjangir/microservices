package com.jangir.loanservice.exception;


import com.jangir.loanservice.dto.ErrorResponseDto;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoanAlreadyExistException.class)
    public ResponseEntity<ErrorResponseDto> handleLoanAlreadyExistException(LoanAlreadyExistException e, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponseDto(
                request.getDescription(false),
                HttpStatus.BAD_REQUEST,
                e.getMessage(),
                LocalDateTime.now()
        ), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException e, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponseDto(
                request.getDescription(false),
                HttpStatus.NOT_FOUND,
                e.getMessage(),
                LocalDateTime.now()
        ), HttpStatus.NOT_FOUND);
    }
}
