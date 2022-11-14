package com.scaler.splitwise.services;

import com.scaler.splitwise.dtos.CreateUserDto;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.repositories.UserRepository;
import com.scaler.splitwise.services.interfaces.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository repository;
    private PasswordEncoder encoder;

    public User createUser(CreateUserDto request) {
        String hashedPassword = encoder.encode(request.getPassword());
        User user = request.user(hashedPassword);
        return repository.save(user);
    }

    public User getUser(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<User> getUsers(Set<Long> userIds) {
        return repository.findAllById(userIds);
    }
}
