package com.ecommerce.ecoomerce_Sring_boot_P1.User.Controller;

import com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity.DTO.UserRequestDTO;
import com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity.DTO.UserResponseDTO;
import com.ecommerce.ecoomerce_Sring_boot_P1.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class Usercontroller {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> registerNewUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO=userService.newUser(userRequestDTO);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);

    }

    @PostMapping("/signin")
    public ResponseEntity<UserResponseDTO> loginUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO=userService.login(userRequestDTO);
        return new ResponseEntity<>(userResponseDTO,HttpStatus.ACCEPTED);
    }
}
