package com.scaler.splitexpense.commands;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private List<Command> commands = new ArrayList<>();

    public void addCommands(List<Command> command) {
        commands.addAll(command);
    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }

    // splitwise register tantia t@t
    public void execute(String input) {
        for (Command command : commands) {
            // See if command can handle this input
            if (command.matches(input)) {
                command.execute(input);
                break;
            }
        }
    }
}