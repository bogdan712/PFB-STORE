package com.kreitek.demo.application.service;

import com.kreitek.demo.application.dto.UserDTO;

public interface UserService {

    UserDTO saveUser(UserDTO user);

    UserDTO findUserByNickname(String nickname);

    UserDTO registerUser(UserDTO userDTO);

}
