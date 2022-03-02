package com.scaler.lld.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

import com.scaler.lld.tictactoe.strategies.WinningStrategy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {

    private Board board;
    private List<Player> players = new ArrayList<>();
    private WinningStrategy strategy;

    public static Builder getBuilder() {
        return new Builder();
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
