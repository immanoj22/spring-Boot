package com.security.spring_security_01.service;

import com.security.spring_security_01.Exceptions.UsernameNotExist;
import com.security.spring_security_01.model.DTO.UserReuestdto;
import com.security.spring_security_01.model.Mapper.UserMapper;
import com.security.spring_security_01.model.User;
import com.security.spring_security_01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(12);

    public User newuser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public UserReuestdto login(UserReuestdto userReuestdto){
        UserMapper userMapper=new UserMapper();
        User requeser=userMapper.reuestToEntity(userReuestdto);

        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requeser.getUsername(),requeser.getPassword())
        );
        if(!authentication.isAuthenticated()){
           throw new UsernameNotExist("user not found");
        }
        String token=jwtService.genrateToken(requeser);
        userReuestdto.setToken(token);
        return  userReuestdto;
    }


}
