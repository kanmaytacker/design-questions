package com.scaler.splitwise.commands;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandRegistry {
    private List<Command> commands = new ArrayList<>();

    public CommandRegistry(RegisterUserCommand registerUserCommand) {
        commands.add(registerUserCommand);
    }

    public boolean registerCommand(Command command) {
        if (commands.contains(command)) {
            return false;
        }

        commands.add(command);
        return true;
    }

    public boolean unregister(Command command) {
        commands.remove(command);
        return true;
    }

    public void execute(String input) {
        for (Command command : commands) {
            if (command.matches(input)) {
                command.execute(input);
                return;
            }
        }
    }
}
