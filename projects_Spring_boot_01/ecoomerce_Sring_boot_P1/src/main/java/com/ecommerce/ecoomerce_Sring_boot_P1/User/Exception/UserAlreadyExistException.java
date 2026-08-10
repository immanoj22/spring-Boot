package com.ecommerce.ecoomerce_Sring_boot_P1.User.Exception;

public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException(){
        super("user Already exists");
    }
}
