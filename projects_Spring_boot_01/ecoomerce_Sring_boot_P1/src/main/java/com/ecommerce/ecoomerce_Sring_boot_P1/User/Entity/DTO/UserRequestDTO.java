package com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity.DTO;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Scope("prototype")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    private String userName;

    private String role;

    private String profilePic;

    private String email;

//    private String password;

}
