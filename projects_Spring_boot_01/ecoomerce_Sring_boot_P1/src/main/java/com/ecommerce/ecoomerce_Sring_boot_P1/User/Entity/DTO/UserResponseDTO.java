package com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Scope("prototype")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private String userName;
    private String role;

    private String profilePic;

    private String email;

    private boolean is2FaEnabled;
    private LocalDateTime otpValidTill;
}
