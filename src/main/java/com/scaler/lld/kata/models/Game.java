package com.scaler.lld.kata.models;

import com.scaler.lld.kata.exceptions.InvalidMoveException;
import com.scaler.lld.kata.exceptions.InvalidPlayersException;
import com.scaler.lld.kata.strategies.winning.RowWinningStrategy;
import com.scaler.lld.kata.strategies.winning.WinningStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class Game {

    private static final int PLAYER_COUNT = 2;
    private static final GameStatus DEFAULT_STATUS = GameStatus.IN_PROGRESS;

    private Board board;
    private List<Player> players = new ArrayList<>();
    private GameStatus status;
    private int nextPlayerIndex = 0;
    private List<WinningStrategy> winningStrategies = List.of(new RowWinningStrategy());
    private Player winner;
    private Game() {

    }

    public static Builder builder() {
        return new Builder();
    }

    public void start() {
        // Assign a random value to the nextPlayerIndex
        // Random value -> 0 or 1
        // 0.5 * 2 = 1.0 = 1
        // 0.1 * 2 = 0.2 = 0
        // 0.8 * 2 = 1.6 = 1
        nextPlayerIndex = (int) (Math.random() * players.size());

        // Set the status to IN_PROGRESS
        status = GameStatus.IN_PROGRESS;
    }

    public void makeMove() {

        BoardCell move = getNextMove();
        board.update(move);

        // Check for a winner
        if (checkWinner(move.getSymbol())) {
            status = GameStatus.FINISHED;
            winner = getNextPlayer();
            return;
        }
        // Check for a draw

        if (checkDraw()) {
            status = GameStatus.DRAWN;
            return;
        }

        // Update the next player
        // 0, 1, 2
        // 0 + 1 = 1
        // 1 + 1 = 2
        // 2 + 1 = 3 % 3 = 0
        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
    }

    private void validateMove(BoardCell move) {
        if (!board.isEmpty(move.getRow(), move.getColumn())) {
            throw new InvalidMoveException(move.getRow(), move.getColumn());
        }
    }

    private BoardCell getNextMove() {

        Player player = players.get(nextPlayerIndex);

        BoardCell move = player.makeMove(board);
        validateMove(move);

        return move;
    }

    private boolean checkWinner(GameSymbol symbol) {
        for (WinningStrategy strategy : winningStrategies) {
            boolean hasWinner = strategy.checkWinner(getBoard(), symbol);
            if (hasWinner) {
                return true;
            }
        }
        return false;
    }


    private boolean checkDraw() {
        // Task 4 - Implement the check draw method
        // If no cell is empty and there is no winner
        return false;
    }

    public Player getNextPlayer() {
        return players.get(nextPlayerIndex);
    }

    public static class Builder {
        private Game game;

        private Builder() {
            game = new Game();
        }

        public Builder withSize(int size) {
            this.game.board = new Board(size);
            return this;
        }

        public Builder withPlayer(Player player) {
            game.getPlayers().add(player);
            return this;
        }

        public Game build() {
            boolean isValid = validate();
            if (!isValid) {
                throw new InvalidPlayersException();
            }

            Game newGame = new Game();
            newGame.board = game.board;
            newGame.players = game.players;
            newGame.status = DEFAULT_STATUS;

            return newGame;
        }

        private boolean validate() {

            List<Player> players = game.players;
            if (players.size() != PLAYER_COUNT) {
                return false;
            }

            // If symbols are unique
            Set<GameSymbol> symbols = players.stream()
                    .map(Player::getSymbol)
                    .collect(Collectors.toSet());

            return symbols.size() == PLAYER_COUNT;
        }


    }


}

// BREAK - 5:55 - 6:05
//              - 10:35

// Player -> Human -> Bot
