package com.ecommerce.ecoomerce_Sring_boot_P1.User.Exception;

public class UserNotExixt extends RuntimeException {
    public UserNotExixt(String message) {
        super(message);
    }
}
