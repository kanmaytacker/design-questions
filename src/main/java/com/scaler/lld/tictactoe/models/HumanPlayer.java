package com.scaler.lld.tictactoe.models;

import java.util.Scanner;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class HumanPlayer extends Player {

    private User user;

    @Builder.Default
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Move play(Board board) {
        System.out.println("Enter the row and column");
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        return new Move(row, column);
    }
    
}
