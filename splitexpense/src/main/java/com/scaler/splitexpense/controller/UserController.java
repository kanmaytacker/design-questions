package com.scaler.splitexpense.controller;

import com.scaler.splitexpense.dtos.CreateUserDto;
import com.scaler.splitexpense.models.User;
import com.scaler.splitexpense.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;

    // Transformation
    public User createUser(CreateUserDto request) {
        return userService.createUser(request.toUser());
    }
}
