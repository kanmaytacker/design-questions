package com.scaler.bookmyshow.dtos;

import com.scaler.bookmyshow.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {

    private String email;

    private Integer test;

    public User toUser() {
        User user = new User();
        user.setEmail(email);
        return user;
    }
}
