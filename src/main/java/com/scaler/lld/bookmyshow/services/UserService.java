package com.scaler.lld.bookmyshow.services;

import com.scaler.lld.bookmyshow.dtos.CreateUserDTO;
import com.scaler.lld.bookmyshow.models.Role;
import com.scaler.lld.bookmyshow.models.User;
import com.scaler.lld.bookmyshow.repositories.interfaces.UserRepository;
import com.scaler.lld.bookmyshow.services.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public User createUser(CreateUserDTO userRequest) {

        User user = new User(userRequest.getUsername());
        user.setPassword(userRequest.getPassword(), passwordEncoder);
        
        Role role = roleService.getRole(userRequest.getRoleName());
        user.addRole(role);

        return userRepository.save(user);
    }

    public boolean doesUserExist(String username, String email) {
        
        if (userRepository.findUserByUsername(username).isPresent()) {
            return true;
        }

        if (userRepository.findUserByEmail(email).isPresent()) {
            return true;
        }

        return false;
    }

}
