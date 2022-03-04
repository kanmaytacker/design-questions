package com.scaler.lld.snakesladders.commands;

import java.util.HashSet;
import java.util.Set;

public class CommandRegistry {
    
    Set<Command> commands = new HashSet<>();

    public void register(Command command) {
        commands.add(command);
    }

    public void deregister(Command command) {
        commands.remove(command);
    }

    public void execute(String incomingCommand) {
        for (Command command: commands) {
            if (command.matches(incomingCommand)) {
                command.execute(incomingCommand);
                return;
            }
        }

        throw new RuntimeException("No command found for: " + incomingCommand);
    }
    
}
