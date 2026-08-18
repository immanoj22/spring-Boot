package com.security.spring_security_01.service;

import com.security.spring_security_01.model.User;
import com.security.spring_security_01.model.Userprinciple;
import com.security.spring_security_01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Userdetailservices implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=userRepository.findByUsername(username);

        if(user==null){
            throw new UsernameNotFoundException("user not found exception");
        }


        return new Userprinciple(user);
    }
}
