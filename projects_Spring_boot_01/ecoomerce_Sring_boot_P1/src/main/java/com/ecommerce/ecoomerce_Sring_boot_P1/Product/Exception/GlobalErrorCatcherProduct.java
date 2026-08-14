package com.ecommerce.ecoomerce_Sring_boot_P1.Product.Exception;

import com.ecommerce.ecoomerce_Sring_boot_P1.commonUtlis.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalErrorCatcherProduct {

    @ExceptionHandler(CommonError.class)
    public ResponseEntity<ErrorResponse> commonError(CommonError commonError){

        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setMessage(commonError.getMessage());
        errorResponse.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
