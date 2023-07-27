package com.scaler.bms.dtos;

import com.scaler.bms.models.User;
import lombok.*;

@Data
public class CreateUserRequest {
    private String name;
    private String email;
    private String password;

    public User toUser() {
        return new User(name, email, password);
    }
}
