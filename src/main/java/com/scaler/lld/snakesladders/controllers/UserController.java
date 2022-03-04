package com.scaler.lld.snakesladders.controllers;

import com.scaler.lld.snakesladders.models.User;
import com.scaler.lld.snakesladders.services.UserService;

public class UserController {
    
    private UserService userService = new UserService();

    public User createUser(Integer id, String username, String email) {
        return userService.createUser(id, username, email);
    }
}
