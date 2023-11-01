package com.scaler.splitexpense.commands;

import com.scaler.splitexpense.controllers.UserController;
import com.scaler.splitexpense.dtos.CreateUserRequest;
import com.scaler.splitexpense.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

// Step 2 - Create the concrete command classes
@Component
@AllArgsConstructor
public class CreateUserCommand implements Command {

    private UserController userController;
    @Override
    public boolean matches(String input) {
        List<String> tokens = Arrays.stream(input.split(" ")).toList();
        // register tantia t@t.com 1857
        String command = tokens.get(0);
        if (!command.equals(Commands.REGISTER_USER_COMMAND)) {
            return false;
        }

        if (tokens.size() < 5) {
            return false;
        }

        return true;
    }

    @Override
    public void execute(String input) {
        System.out.println("Executing create user command");
        List<String> tokens = Arrays.stream(input.split(" ")).toList();
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