package com.backend.houserenting.security.jwt;

import com.backend.houserenting.security.entity.MainUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

//Genera y valida el token
@Component
public class JwtProvider {

    private final static Logger logger = (Logger) LoggerFactory.getLogger(JwtProvider.class);
    @Value("${jwt.secret}")
    private Key secret;
    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication){
        MainUser mainUser = (MainUser) authentication.getPrincipal();
        return Jwts.builder().setSubject(mainUser.getUsername()).setExpiration(new Date(new Date().getTime() + expiration*1000)).signWith(secret,SignatureAlgorithm.ES512).compact();
    }

    public String getUserNameFromToke(String token){
        return Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToke(String token){
        return false;
    }
}
