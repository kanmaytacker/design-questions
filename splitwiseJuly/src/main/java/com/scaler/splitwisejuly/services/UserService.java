package com.scaler.splitwisejuly.services;

import com.scaler.splitwisejuly.models.User;
import com.scaler.splitwisejuly.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
