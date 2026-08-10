package com.ecommerce.ecoomerce_Sring_boot_P1.User.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalUserException {

    @ExceptionHandler(UserValidationException.class)
    public ResponseEntity<Map<String,String>> handleUserValidation(UserValidationException userValidationException){
        return new ResponseEntity<>(userValidationException.getError(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<String> handleUserExists(UserAlreadyExistException userAlreadyExistException){
        return new ResponseEntity<>(userAlreadyExistException.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
