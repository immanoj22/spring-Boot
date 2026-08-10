package com.ecommerce.ecoomerce_Sring_boot_P1.User.Exception;

import java.util.Map;

public class UserValidationException extends RuntimeException{

    private  Map<String,String> error;

    public UserValidationException(Map<String,String> errors){
        super("User validation failed");
        error=errors;
    }

    public Map<String,String> getError(){
        return error;
    }
}
