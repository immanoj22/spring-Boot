package com.security.spring_security_01.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Globalxception {

    @ExceptionHandler(UsernameNotExist.class)
    public ResponseEntity<String> usernotExist(UsernameNotExist usernameNotExist){
        String message=usernameNotExist.getMessage();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
