package com.security.spring_security_01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security/v1")
public class Learning_Cntroller {

    @GetMapping("/hello")
    public String helloFrmSprnig(){
        return "hello";
    }
}
