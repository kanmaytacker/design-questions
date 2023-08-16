package com.scaler.splitwisejuly.controllers;

import com.scaler.splitwisejuly.dtos.CreateUserRequest;
import com.scaler.splitwisejuly.models.User;
import com.scaler.splitwisejuly.services.UserService;
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
