package com.ecommerce.ecoomerce_Sring_boot_P1.User.Exception;

public class UserPasswordWrong extends RuntimeException {
    public UserPasswordWrong(String message) {
        super(message);
    }
}
