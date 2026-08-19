package com.security.spring_security_01.Config;

import com.security.spring_security_01.service.JWTService;
import com.security.spring_security_01.service.Userdetailservices;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService jwtService;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token=null;
        String userName=null;
        String authHeader=request.getHeader("Authorization") !=null ? request.getHeader("Authorization"):null;

        if(authHeader != null && authHeader.startsWith("Bearer ")){
            token=authHeader.substring(7);
            userName=jwtService.extractUsername(token);
        }

        System.out.println("username : "+userName+ " Token "+token+ " authHeader"+authHeader);
        if(userName !=null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails=applicationContext.getBean(Userdetailservices.class).loadUserByUsername(userName);

            if(jwtService.validate(token,userDetails)){
                UsernamePasswordAuthenticationToken auth=
                        new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        filterChain.doFilter(request,response);
    }
}
