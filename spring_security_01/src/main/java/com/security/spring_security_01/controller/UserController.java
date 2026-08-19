package com.security.spring_security_01.controller;

import com.security.spring_security_01.model.DTO.UserReuestdto;
import com.security.spring_security_01.model.User;
import com.security.spring_security_01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security/v1/authentication")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/newUser")
    public ResponseEntity<User> saveuser(@RequestBody User user){
        User saveduser= userService.newuser(user);
        return new ResponseEntity<>(saveduser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserReuestdto> loginUser(@RequestBody UserReuestdto userReuestdto){
        UserReuestdto saveduser= userService.login(userReuestdto);
        return new ResponseEntity<>(saveduser, HttpStatus.OK);
    }
}
