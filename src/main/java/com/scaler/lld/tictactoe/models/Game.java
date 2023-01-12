package com.scaler.lld.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {

    private Board board;
    private List<Player> players = new ArrayList<>();
    private GameStatus status;
    private int nextPlayerIndex = 0;

    public static Builder getBuilder() {
        return new Builder();
    }

    public Player getNextPlayer() {
        return players.get(nextPlayerIndex);
    }

    public void makeMove() {

        // Get the next player
        Player player = getNextPlayer();

        // Get the move from the player. You can use Scanner to get the input from the user
        Move move = player.play(board);

        // Validate if the cell is not empty
        // If not, throw a custom exception
        if (!board.isEmpty(move.getRow(), move.getColumn())) {
            throw new RuntimeException("Cell is not empty");
        }
        System.out.println("Move happened at row: " + move.getRow() + " Column: " + move.getColumn());


        // Update the board
        board.getCells().get(move.getRow()).get(move.getColumn()).setSymbol(player.getSymbol());

        if (checkWinner(player.getSymbol())) {
            status = GameStatus.ENDED;
            return;
        }

        if (checkDraw()) {
            status = GameStatus.DRAW;
            return;
        }

        // Update the next player index
        this.nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
        System.out.println("Next player index: " + this.nextPlayerIndex);
    }

    public boolean checkWinner(GameSymbol gameSymbol) {
        // Check if any 3 consecutive on the row
        return checkRows(gameSymbol);
    }

    private boolean checkRows(GameSymbol gameSymbol) {
        List<List<BoardCell>> cells = board.getCells();
        for (List<BoardCell> row : cells) {
            boolean isWinner = true;
            for (BoardCell cell : row) {
                if (cell.getSymbol() != gameSymbol) {
                    isWinner = false;
                    break;
                }
            }
            if (isWinner) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDraw() {
        return board.getAvailableCells().isEmpty(); 
    }

    public static class Builder {

        private Game game;

        Builder() {
            this.game = new Game();
        }

        public Builder withDimension(int rows, int columns) {
            Board board = new Board(rows, columns);
            this.game.setBoard(board);
            return this;
        }

        private boolean validate() {
            List<Player> players = game.getPlayers();
            if (players.size() > 2) {
                return false;
            }
            return true;
        }

        public Game build() {

            boolean isValid = validate();
            if (!isValid) {
                throw new RuntimeException("Game is not valid");
            }

            this.game.setStatus(GameStatus.IN_PROGRESS);
            return this.game;
        }

        public Builder withPlayer(Player player) {
            game.getPlayers().add(player);
            return this;
        }
    }

    public void printBoard() {
        board.printBoard();
    }
}
