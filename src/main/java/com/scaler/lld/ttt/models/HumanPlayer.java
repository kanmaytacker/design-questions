package com.scaler.lld.ttt.models;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Scanner;

//Extrinisc state
@AllArgsConstructor
public class HumanPlayer extends Player{
    private User user;
    @Builder.Default
    private Scanner scan = new Scanner(System.in);
    public HumanPlayer(GameSymbol symbol, User user) {
        super(symbol);
        this.user = user;
    }

    @Override
    public BoardCell makeMove(Board board) {
        System.out.println("Enter row and column");
        int row = scan.nextInt();
        int col = scan.nextInt();
        return new BoardCell(row, col,getSymbol());
    }
}
