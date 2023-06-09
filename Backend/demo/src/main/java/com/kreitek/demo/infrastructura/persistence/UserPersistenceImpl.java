package com.kreitek.demo.infrastructura.persistence;

import com.kreitek.demo.domain.entity.User;
import com.kreitek.demo.domain.persistence.UserPersistence;
import com.kreitek.demo.domain.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPersistenceImpl implements UserPersistence {

    private final UserRepository repository;

    @Autowired
    public UserPersistenceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public User findUserByNickname(String nickname) {
        return repository.findByNickname(nickname);
    }
}
