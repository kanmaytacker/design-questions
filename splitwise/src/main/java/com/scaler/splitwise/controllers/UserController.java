package com.scaler.splitwise.controllers;

import com.scaler.splitwise.dtos.CreateUserDto;
import com.scaler.splitwise.dtos.GetUserDto;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    private static void validate(CreateUserDto user) {
        if (user.getName() == null) {
            throw new RuntimeException("No name present!");
        }

        if (user.getPassword() == null) {
            throw new RuntimeException("No password present!");
        }
    }

    @PostMapping("/user")
    public GetUserDto createUser(@RequestBody CreateUserDto user) {
        validate(user);
        return toResponse(userService.createUser(user));
    }

    @GetMapping("/user/{id}")
    public GetUserDto getUser(@PathVariable Long id) {
        return toResponse(userService.getUser(id));
    }

    private GetUserDto toResponse(User user) {
        if (user == null) {
            return null;
        }

        return new GetUserDto(user.getName(), user.getPhoneNumber());
    }
}
