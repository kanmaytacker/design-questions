package com.scaler.bms.controllers;

import com.scaler.bms.dtos.CreateUserRequest;
import com.scaler.bms.dtos.GetUserResponse;
import com.scaler.bms.models.User;
import com.scaler.bms.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/user")
    public GetUserResponse createUser(@RequestBody CreateUserRequest request) {
        User user = userService.createUser(request.toUser());
        return GetUserResponse.fromUser(user);
    }
}

// Create a user -> POST /api/v1/user
// Fetch a user -> GET /api/v1/user/:id

// User -> id = 1
// Ctor injection -> new User(1)
// Setter injection -> new User(); user.setId(1)
// Field injection -> new User(); user.id = 1