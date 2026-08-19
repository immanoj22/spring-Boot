package com.security.spring_security_01.service;

import com.security.spring_security_01.model.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {

    @Value("${jwt.secret}")
    private String secretkey;

    public String genrateToken(User requeser) {

        Map<String, Object> claims=new HashMap<>();

        claims.put("userName",requeser.getUsername());


        return Jwts
                .builder()
                .claims(claims)
                .subject(requeser.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000*60*10))
                .signWith(getkey())
                .compact();
    }

    private Key getkey(){
        byte[] keybytes= Decoders.BASE64.decode(secretkey);
        return Keys.hmacShaKeyFor(keybytes);
    }
}
