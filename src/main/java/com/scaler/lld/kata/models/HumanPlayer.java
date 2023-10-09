package com.scaler.lld.kata.models;

import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.util.Scanner;

// Extrinsic state
@SuperBuilder
public class HumanPlayer extends Player {
    private User user;



    public HumanPlayer(GameSymbol symbol, User user) {
        super(symbol);
        this.user = user;
    }

    @Override
    public BoardCell makeMove(Board board) {
        System.out.println("Enter row and column");
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        return new BoardCell(row, column, getSymbol());
    }
}
