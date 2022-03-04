package com.scaler.lld.snakesladders.services;

import com.scaler.lld.snakesladders.models.User;
import com.scaler.lld.snakesladders.repositories.UserRepository;

public class UserService {

    UserRepository userRepository = new UserRepository();

    public User createUser(Integer id, String username, String email) {
        return userRepository.save(
                User.builder()
                        .id(id)
                        .username(username)
                        .email(email)
                        .build()

        );
    }

}
