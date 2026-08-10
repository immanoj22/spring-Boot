package com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity.DTO;

import com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserMapper {

    @Autowired
    UserResponseDTO userResponseDTO;

    public User response_To_Entity(UserRequestDTO userRequestDTO){

    }
}
