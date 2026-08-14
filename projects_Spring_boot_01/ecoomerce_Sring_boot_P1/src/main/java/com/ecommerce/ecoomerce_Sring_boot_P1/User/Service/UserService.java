package com.ecommerce.ecoomerce_Sring_boot_P1.User.Service;

import com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity.DTO.UserMapper;
import com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity.DTO.UserRequestDTO;
import com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity.DTO.UserResponseDTO;
import com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity.User;
import com.ecommerce.ecoomerce_Sring_boot_P1.User.Exception.CommonUserError;
import com.ecommerce.ecoomerce_Sring_boot_P1.User.Exception.UserAlreadyExistException;
import com.ecommerce.ecoomerce_Sring_boot_P1.User.Exception.UserNotExixt;
import com.ecommerce.ecoomerce_Sring_boot_P1.User.Exception.UserPasswordWrong;
import com.ecommerce.ecoomerce_Sring_boot_P1.User.Repository.UserRepository;
import com.ecommerce.ecoomerce_Sring_boot_P1.User.Utils.UserUtils;
import com.ecommerce.ecoomerce_Sring_boot_P1.User.Validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

        //genrate otp and send otp here

        User savedUSer=userRepository.save(user);

        return userMapper.entity_to_response(savedUSer);
    }

    public UserResponseDTO login(UserRequestDTO userRequestDTO) {

        userValidator.validateLoginUSer(userRequestDTO);

        Optional<User> existingUser =userRepository.findByEmail(userRequestDTO.getEmail());

        if (!existingUser.isPresent()) {
            throw new UserNotExixt("entered email id has no user");
        }

        User user=existingUser.get();

        if(!(user.getPassword().equals(userRequestDTO.getPassword()))){
            throw new UserPasswordWrong("inccorect password");
        };

        String otp=userRequestDTO.getOtp();

        if(!otp.isEmpty()){
            user.setOtp(UserUtils.genrateOtp(6));
            user.setOtpValidTill(LocalDateTime.now().plusSeconds(120));

            User savedUSer=userRepository.save(user);
            return userMapper.entity_to_response(savedUSer);
        }

        if(!(user.getOtp().equals(userRequestDTO.getOtp()))){
            throw new CommonUserError("Wrong otp ");
        }else if(user.getOtpValidTill().isAfter(LocalDateTime.now())){
            throw new CommonUserError("Time over genrate new otp");
        }

        return userMapper.entity_to_response(user);
    }
}
