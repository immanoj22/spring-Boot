package com.security.spring_security_01.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReuestdto {
    private String username;

    private Integer age;

    private String password;

    private String token;
}
