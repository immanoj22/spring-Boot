package com.security.spring_security_01.model.Mapper;

import com.security.spring_security_01.model.DTO.UserReuestdto;
import com.security.spring_security_01.model.User;

public class UserMapper {

    public User reuestToEntity(UserReuestdto userReuestdto){
        User user=new User();
//        user.get
        return user;
    }
}
