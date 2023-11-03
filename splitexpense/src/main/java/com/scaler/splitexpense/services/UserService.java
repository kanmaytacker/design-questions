package com.scaler.splitexpense.services;

import com.scaler.splitexpense.models.User;
import com.scaler.splitexpense.repositories.UserRepository;
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
