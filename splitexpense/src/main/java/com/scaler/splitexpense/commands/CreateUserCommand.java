package com.scaler.splitexpense.commands;

import com.scaler.splitexpense.controllers.UserController;
import com.scaler.splitexpense.dtos.CreateUserRequest;
import com.scaler.splitexpense.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

// Step 2 - Create the concrete command classes
@Component
@AllArgsConstructor
public class CreateUserCommand implements Command {

    private UserController userController;

    @Override
    public boolean matches(String input) {
        String command = Command.getCommand(input);
        if (!command.equals(Commands.REGISTER_USER_COMMAND)) {
            return false;
        }

        return true;
    }


    @Override
    public void execute(String input) {
        System.out.println("Executing create user command");
        List<String> tokens = Command.getTokens(input);
        CreateUserRequest request = CreateUserRequest.builder()
                .name(tokens.get(1))
                .email(tokens.get(2))
                .password(tokens.get(3))
                .phoneNumber(tokens.get(4))
                .build();

        User user = userController.createUser(request);
        System.out.println("Created user with id: " + user.getId());
    }
}