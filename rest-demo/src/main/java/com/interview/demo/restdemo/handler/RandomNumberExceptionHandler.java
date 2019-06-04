package com.interview.demo.restdemo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RandomNumberExceptionHandler{
	@ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String  handleNumberFormat(NumberFormatException ex, WebRequest request) {
        return new String("Bad Request "+ex.getMessage());
    }
}