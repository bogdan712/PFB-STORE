package com.kreitek.demo.infrastructura.persistence;

import com.kreitek.demo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByNickname(String nickname);
    User findByEmail(String email);
}
