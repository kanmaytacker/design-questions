package com.scaler.splitwise.services;

import com.scaler.splitwise.dtos.CreateUserDto;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository repository;

    public User createUser(CreateUserDto request) {
        User user = request.user();
        return repository.save(user);
    }

    public User getUser(Long id) {
        return repository.findById(id).orElse(null);
    }
}
