package com.example.demo.exception;



//@ResponseStatus(value = HttpStatus.NOT_FOUND) not managed by apiExceptionHandlre
public class NotFoundException extends  RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
