package com.ecommerce.ecoomerce_Sring_boot_P1.User.Service;

import com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity.DTO.UserMapper;
import com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity.DTO.UserRequestDTO;
import com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity.DTO.UserResponseDTO;
import com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity.User;
import com.ecommerce.ecoomerce_Sring_boot_P1.User.Exception.UserAlreadyExistException;
import com.ecommerce.ecoomerce_Sring_boot_P1.User.Repository.UserRepository;
import com.ecommerce.ecoomerce_Sring_boot_P1.User.Validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private  UserMapper userMapper;
    public UserResponseDTO newUser(UserRequestDTO userRequestDTO) {

        userValidator.validateNewUSerData(userRequestDTO);

        Optional<User> existingUser =userRepository.findByEmail(userRequestDTO.getEmail());

        if (existingUser.isPresent()) {
            throw new UserAlreadyExistException();
        }

        User user=userMapper.request_To_Entity(userRequestDTO);

        User savedUSer=userRepository.save(user);
        return userMapper.entity_to_response(savedUSer);
    }
}
