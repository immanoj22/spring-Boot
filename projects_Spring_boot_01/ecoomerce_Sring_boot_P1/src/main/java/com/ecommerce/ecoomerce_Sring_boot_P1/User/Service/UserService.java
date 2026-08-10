package com.ecommerce.ecoomerce_Sring_boot_P1.User.Service;

import com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity.DTO.UserRequestDTO;
import com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity.DTO.UserResponseDTO;
import com.ecommerce.ecoomerce_Sring_boot_P1.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository UserRepository;
    public UserResponseDTO newUser(UserRequestDTO userRequestDTO) {

    }
}
