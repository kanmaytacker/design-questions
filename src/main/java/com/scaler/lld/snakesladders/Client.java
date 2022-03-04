package com.scaler.lld.snakesladders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.scaler.lld.snakesladders.commands.CommandRegistry;
import com.scaler.lld.snakesladders.commands.CreateGame;
import com.scaler.lld.snakesladders.commands.CreateUser;
import com.scaler.lld.snakesladders.exceptions.InvalidCommandException;

public class Client {
    public static void main(String[] args) {
        CommandRegistry commandRegistry = createRegistry();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println(">");
            try {
                String input = br.readLine().toString();
                commandRegistry.execute(input);
            } catch (InvalidCommandException e) {
                System.out.println("Command is invalid");
            } catch (IOException e) {
                System.out.println("ISE: System error");
            }

        }
    }

    private static CommandRegistry createRegistry() {

        CommandRegistry registry = new CommandRegistry();

        registry.register(new CreateUser());
        registry.register(new CreateGame());
        return registry;
    }
}
