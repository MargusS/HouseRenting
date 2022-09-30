package com.backend.houserenting.security.controller;

import com.backend.houserenting.dto.Message;
import com.backend.houserenting.security.dto.JwtDto;
import com.backend.houserenting.security.dto.LoginUser;
import com.backend.houserenting.security.dto.NewUser;
import com.backend.houserenting.security.entity.Rol;
import com.backend.houserenting.security.entity.User;
import com.backend.houserenting.security.enumjwt.RolName;
import com.backend.houserenting.security.jwt.JwtProvider;
import com.backend.houserenting.security.service.RolService;
import com.backend.houserenting.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/newUser")
    public ResponseEntity<?> userRegister(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity<>(new Message("Invalid inputs"), HttpStatus.BAD_REQUEST);
        if(userService.existsByUserName(newUser.getUserName()))
            return new ResponseEntity<>(new Message("Name alredy exists"),HttpStatus.BAD_REQUEST);
        if(userService.existsByEmail(newUser.getEmail()))
            return new ResponseEntity<>(new Message("Email alredy exists"),HttpStatus.BAD_REQUEST);
        User user = new User(newUser.getName(),newUser.getUserName(),newUser.getEmail(), newUser.getPh_number(),passwordEncoder.encode(newUser.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolName(RolName.ROLE_USER).get());
        if(newUser.getRoles().contains("admin"))
            roles.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity<>(new Message("Registration Completed"),HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser,BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("Invalid inputs"), HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUserName(),loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt,userDetails.getUsername(),userDetails.getAuthorities());
        return new ResponseEntity<>(jwtDto,HttpStatus.OK);
    }
}
