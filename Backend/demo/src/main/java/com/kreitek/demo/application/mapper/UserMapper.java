package com.kreitek.demo.application.mapper;

import com.kreitek.demo.application.dto.UserDTO;
import com.kreitek.demo.domain.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {
}

