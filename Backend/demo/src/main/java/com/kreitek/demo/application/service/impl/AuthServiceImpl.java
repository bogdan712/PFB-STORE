package com.kreitek.demo.application.service.impl;

import com.kreitek.demo.domain.entity.User;
import com.kreitek.demo.domain.persistence.UserPersistence;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {

    private final UserPersistence userPersistence;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(UserPersistence userPersistence,
                           PasswordEncoder passwordEncoder,
                           AuthenticationManager authenticationManager) {
        this.userPersistence = userPersistence;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public String authenticateUser(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Here you should generate a JWT token and return it.
        return "JWT token";
    }

    public User registerUser(User newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return userPersistence.save(newUser);
    }
}
