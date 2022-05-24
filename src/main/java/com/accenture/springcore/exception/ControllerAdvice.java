package com.accenture.springcore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler({NoSuchElementException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleException(NoSuchElementException e) {
        System.out.println("Handled exception");
        return new ExceptionResponse(e.getMessage(), 123455, null);
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleGenericException(Exception e) {
        return new ExceptionResponse(e.getMessage(), 0, null);
    }

    @ExceptionHandler({AccessDeniedException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionResponse handleAccessDeniedException(AccessDeniedException e) {
        return new ExceptionResponse(e.getMessage(), 1231231, null);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleGenericException(MethodArgumentNotValidException e) {
        return new ExceptionResponse(e.getMessage(), 1110, null);
    }
}
