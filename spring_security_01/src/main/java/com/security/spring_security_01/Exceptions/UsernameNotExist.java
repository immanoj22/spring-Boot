package com.security.spring_security_01.Exceptions;

public class UsernameNotExist extends RuntimeException {
    public UsernameNotExist(String userNotFound) {
        super(userNotFound);
    }
}
