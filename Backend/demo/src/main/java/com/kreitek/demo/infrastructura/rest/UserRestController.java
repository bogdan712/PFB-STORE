package com.kreitek.demo.infrastructura.rest;

import com.kreitek.demo.application.dto.UserDTO;
import com.kreitek.demo.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {
    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @PostMapping(value = "/register", produces = "application/json", consumes = "application/json")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO){
        UserDTO registeredUser = this.userService.saveUser(userDTO);
        return  new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PostMapping(value = "/login", produces = "application/json", consumes = "application/json")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO){
        UserDTO existingUser = this.userService.findUserByNickname(userDTO.getNickname());

        if (existingUser != null && existingUser.getPassword().equals(userDTO.getPassword())) {
            return ResponseEntity.ok(existingUser);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
