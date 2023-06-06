package com.kreitek.demo.infrastructura.rest;


import com.kreitek.demo.application.dto.UserDTO;
import com.kreitek.demo.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    private final UserService service;

    @Autowired
    public AuthRestController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserDTO user) {
        UserDTO savedUser = service.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@Valid @RequestBody UserDTO user) {
        UserDTO existingUser = service.findUserByNickname(user.getNickname());

        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok(existingUser);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

