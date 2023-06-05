package com.kreitek.demo.domain.persistence;

import com.kreitek.demo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPersistence extends JpaRepository<User, Long> {
    User findByNickname(String nickname);
    User findByEmail(String email);
}
