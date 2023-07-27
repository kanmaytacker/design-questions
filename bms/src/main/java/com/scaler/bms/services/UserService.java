package com.scaler.bms.services;

import com.scaler.bms.models.User;
import com.scaler.bms.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User createUser(User user) {
        System.out.println("Got request for in service: " + user.getEmail() + " with pwd: " + user.getPassword());
        return userRepository.save(user);
    }

    public User getUserInternal(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
