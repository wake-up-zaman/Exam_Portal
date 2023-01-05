package com.example.Exam.Portal.Application.controllers;

import com.example.Exam.Portal.Application.config.JwtUtils;
import com.example.Exam.Portal.Application.entities.JwtRequest;
import com.example.Exam.Portal.Application.entities.TokenDto;
import com.example.Exam.Portal.Application.entities.User;
import com.example.Exam.Portal.Application.services.UserService;
import com.example.Exam.Portal.Application.servicesImpl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManagers;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/generate_token")
    public TokenDto generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{
            System.out.println(jwtRequest.getUsername());
            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        }
        catch(UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("User Not Found");
        }
        UserDetails userDetails=this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
        String token=this.jwtUtils.generateToken(userDetails);

        User user1=this.userService.getUser(jwtRequest.getUsername());
        System.out.println(user1.getId());



        TokenDto tokendto=new TokenDto();
        tokendto.setUsername(user1.getUsername());
        tokendto.setToken(token);
        tokendto.setUserRoles(user1.getUserRoles());
        return tokendto;
    }

    private void authenticate(String username,String password) throws Exception {

        try{
                authenticationManagers.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }
        catch(DisabledException e){
            throw new Exception("User Disabled "+e.getMessage());
        }
        catch(BadCredentialsException e){
            throw new Exception("Invalid Credential "+e.getMessage());
        }
    }
}
