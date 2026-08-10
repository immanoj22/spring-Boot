package com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity.DTO;

import com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity.User;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMapper {

    public User request_To_Entity(UserRequestDTO userRequestDTO){
        User user=new User();
        user.setUserName(userRequestDTO.getUserName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getRole());

        return user;
    }

    public UserResponseDTO entity_to_response(User user){

        UserResponseDTO userResponseDTO=new UserResponseDTO();
        userResponseDTO.setUserName(user.getUserName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setRole(user.getRole());
        userResponseDTO.setProfilePic(user.getProfilePic().isEmpty() ? "default.png" : user.getProfilePic());
        userResponseDTO.set2FaEnabled(user.is2FaEnabled());
        userResponseDTO.setOtpValidTill(user.getOtpValidTill());

        return userResponseDTO;
    }
}
