package com.backend.houserenting.security.jwt;

import com.backend.houserenting.security.entity.MainUser;
import io.jsonwebtoken.*;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.SignatureException;
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
        return Jwts.builder().setSubject(mainUser.getUsername()).setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + expiration*1000)).signWith(secret,SignatureAlgorithm.ES512).compact();
    }

    public String getUserNameFromToke(String token){
        return Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToke(String token){
        try{
            Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            logger.error("Malformed Token");
        }catch (UnsupportedJwtException e){
            logger.error("Unsupported Token");
        }catch (ExpiredJwtException e){
            logger.error("Expirated Token");
        }catch (IllegalArgumentException e){
            logger.error("Empty Token");
        }
        return false;
    }
}
