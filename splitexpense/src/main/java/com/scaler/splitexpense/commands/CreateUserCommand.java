package com.scaler.splitexpense.commands;

import com.scaler.splitexpense.controller.UserController;
import com.scaler.splitexpense.dtos.CreateUserDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

// Step 2 - Create concrete commands
@Component
@AllArgsConstructor
public class CreateUserCommand implements Command {
    private UserController userController;
    @Override
    public boolean matches(String input) {
        if (getCommand(input).equals(Commands.REGISTER_USER_COMMAND)) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        // UserController
        // Arguments -> register Tantia email password phoneNumber
        List<String> tokens = getTokens(input);

        // Create the user DTO
        CreateUserDto createUserDto = CreateUserDto.builder()
                .name(tokens.get(1))
                .email(tokens.get(2))
                .password(tokens.get(3))
                .phoneNumber(tokens.get(4))
                .build();

        userController.createUser(createUserDto);

    }
}
