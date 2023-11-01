package com.scaler.splitexpense.services;

import com.scaler.splitexpense.models.User;
import com.scaler.splitexpense.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository repository;
    private PasswordEncoder encoder;

    public User createUser(User request) {
        String hashedPassword = encoder.encode(request.getPassword());
        User user = request.toBuilder().password(hashedPassword).build();
        return repository.save(user);
    }

    public User getUser(Long id) {
        return repository.findById(id).orElse(null);
    }
}