package com.scaler.splitwise.commands;

import com.scaler.splitwise.controllers.UserController;
import com.scaler.splitwise.dtos.CreateUserDto;
import com.scaler.splitwise.dtos.GetUserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class RegisterUserCommand implements Command {

    private UserController controller;

    @Override
    public boolean matches(String input) {
        List<String> tokens = List.of(input.split(" "));
        return tokens.get(0).equals(Commands.REGISTER_USER);
    }

    @Override
    public void execute(String input) {
        List<String> tokens = List.of(input.split(" "));
        String name = tokens.get(1);
        String phoneNumber = tokens.get(2);
        String password = tokens.get(3);

        CreateUserDto request = CreateUserDto.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .password(password)
                .build();

        GetUserDto user = controller.createUser(request);
        System.out.println("User Registered");
    }
}
