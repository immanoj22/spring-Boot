package com.security.spring_security_01.model.Mapper;

import com.security.spring_security_01.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.security.spring_security_01.model.DTO.UserReuestdto;

public class UserMapper {

    public User reuestToEntity(UserReuestdto userReuestdto){
        User user=new User();
        user.setUsername(userReuestdto.getUsername());
        user.setPassword(userReuestdto.getPassword());
        user.setAge(userReuestdto.getAge() !=null ? userReuestdto.getAge():0);
        return user;
    }
}
