package com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    private String userName;
    private String role;

    private String profilePic;

    private String email;

    private String password;

    private LocalDateTime joinedAt;

    private String refreshToken;

    private String otp;

    private boolean is2FaEnabled;
    private LocalDateTime otpValidTill;
    private boolean otpTimeRuning;

    private int otpTries;

}
