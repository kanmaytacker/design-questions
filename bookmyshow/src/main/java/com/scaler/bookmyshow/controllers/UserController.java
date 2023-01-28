package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.dtos.CreateUserDto;
import com.scaler.bookmyshow.exceptions.InvalidEmailException;
import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// BREAK
// 5:19 - 5:24
//  - 10:54
@RestController // Tells spring this is a component
@AllArgsConstructor // Ctor that is used for injection
public class UserController {

    private UserService userService;

    // Get a user
    // VERB - endpoint
    // GET  - /user/{id}

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    // Create a user
    // VERB - endpoint
    // POST - /user

    @PostMapping("/user")
    public User createUser(@RequestBody CreateUserDto request) {
        // 1. Request validation
        validate(request);

        // 2. Data transformation
        return userService.createUser(request.toUser());
    }

    private void validate(CreateUserDto request) {
        if (request.getEmail() == null) {
            throw new InvalidEmailException("Email is absent!");
        }
    }

}



// Constructor injection -
//  1. Add component annotations
// 2. Add constructors

// Setter injection


// A a = new A()
// a.b = new B()