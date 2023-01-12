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

    private Player getNextPlayer() {
        return players.get(nextPlayerIndex);
    }

    public void makeMove() {

        // Get the next player
        Player player = getNextPlayer();

        // Get the move from the player. You can use Scanner to get the input from the user
        Move move = player.play(board);

        // Validate if the cell is not empty
        // If not, throw a custom exception
        if (board.isEmpty(move.getRow(), move.getColumn())) {
            throw new RuntimeException("Cell is not empty");
        }

        // Update the board
        board.getCells().get(move.getRow()).get(move.getColumn()).setSymbol(player.getSymbol());

        if (checkWinner()) {
            status = GameStatus.ENDED;
            return;
        }

        if (checkDraw()) {
            status = GameStatus.DRAW;
            return;
        }

        // Update the next player index
        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
    }

    public boolean checkWinner() {
        // Check if the game is over
        return false;
    }

    private boolean checkDraw() {
        // Check if the game is draw
        return false;
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

            return this.game;
        }

        public Builder withPlayer(Player player) {
            game.getPlayers().add(player);
            return this;
        }
    }
}
