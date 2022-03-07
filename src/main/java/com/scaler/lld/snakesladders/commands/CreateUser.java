package com.scaler.lld.snakesladders.commands;

import java.util.Arrays;
import java.util.List;

import com.scaler.lld.snakesladders.controllers.UserController;

public class CreateUser implements Command {

    private static final String COMMAND_NAME = "create_user";
    private UserController controller = new UserController();
    
    @Override
    public void execute(String command) {
        List<String> tokens = Arrays.asList(command.split(" "));
        
        String username = tokens.get(1);
        String email = tokens.get(2);
        int id = generateRandomId();

        controller.createUser(id, username, email);        
    }

    private int generateRandomId() {
        return ((int) Math.random()) + 1;
    }

    @Override
    public boolean matches(String command) {
        List<String> tokens = Arrays.asList(command.split(" "));
        if (tokens.size() > 0 && tokens.get(0).equals(COMMAND_NAME)) {
            return true;
        }
         return false;
    }
    
}
