package com.kreitek.demo.domain.persistence;

import com.kreitek.demo.domain.entity.User;

public interface UserPersistence {

    User saveUser(User user);

    User findUserByNickname(String nickname);
}

