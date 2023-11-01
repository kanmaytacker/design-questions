package com.scaler.splitexpense.controllers;

import com.scaler.splitexpense.dtos.CreateUserRequest;
import com.scaler.splitexpense.models.User;
import com.scaler.splitexpense.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class UserController {
    private UserService userService;
    public User createUser(CreateUserRequest request) {
        return userService.createUser(request.toUser());
    }
}