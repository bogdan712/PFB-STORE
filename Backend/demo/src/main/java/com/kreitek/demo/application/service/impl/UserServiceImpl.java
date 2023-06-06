package com.kreitek.demo.application.service.impl;

import com.kreitek.demo.application.dto.UserDTO;
import com.kreitek.demo.application.mapper.UserMapper;
import com.kreitek.demo.application.service.UserService;
import com.kreitek.demo.domain.entity.User;
import com.kreitek.demo.domain.persistence.UserPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserServiceImpl implements UserService {

    private final UserPersistence persistence;
    private final UserMapper mapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserPersistence persistence, UserMapper mapper, BCryptPasswordEncoder passwordEncoder) {
        this.persistence = persistence;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        // Encriptar contraseña
        userDTO.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));
        User user = this.persistence.saveUser(this.mapper.toEntity(userDTO));
        return this.mapper.toDto(user);
    }


    @Override
    public UserDTO saveUser(UserDTO user) {
        User savedUser = persistence.saveUser(mapper.toEntity(user));
        return mapper.toDto(savedUser);
    }

    @Override
    public UserDTO findUserByNickname(String nickname) {
        User user = persistence.findUserByNickname(nickname);
        return mapper.toDto(user);
    }
}

