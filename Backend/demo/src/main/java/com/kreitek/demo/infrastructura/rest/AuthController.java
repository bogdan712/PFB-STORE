package com.kreitek.demo.infrastructura.rest;

import com.kreitek.demo.application.service.impl.AuthServiceImpl;
import com.kreitek.demo.domain.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthServiceImpl authService;

    public AuthController(AuthServiceImpl authService) {
        this.authService = authService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody User user) {
        String token = authService.authenticateUser(user.getNickname(), user.getPassword());
        return ResponseEntity.ok(token); // Consider creating a proper response model instead of just returning the token string.
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody User newUser) {
        User user = authService.registerUser(newUser);
        return ResponseEntity.ok(user); // Consider creating a proper response model.
    }
}
