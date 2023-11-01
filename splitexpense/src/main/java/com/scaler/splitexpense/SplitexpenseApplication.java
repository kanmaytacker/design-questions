package com.scaler.splitexpense;

import com.scaler.splitexpense.commands.CommandExecutor;
import com.scaler.splitexpense.commands.CreateUserCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
public class SplitexpenseApplication implements CommandLineRunner {
    private CommandExecutor commandExecutor;
    private Scanner scanner;

    public SplitexpenseApplication(CommandExecutor commandExecutor, CreateUserCommand command) {
        this.scanner = new Scanner(System.in);
        this.commandExecutor = commandExecutor;
        this.commandExecutor.addCommand(command);
    }


    public static void main(String[] args) {
        SpringApplication.run(SplitexpenseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {

            System.out.println("Enter input:");
            String input = scanner.nextLine();
            System.out.println("User entered: " + input);

            commandExecutor.execute(input);


        }
    }
}
