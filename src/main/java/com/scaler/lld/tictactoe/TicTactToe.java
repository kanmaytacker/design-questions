package com.scaler.lld.tictactoe;

import com.scaler.lld.tictactoe.models.Bot;
import com.scaler.lld.tictactoe.models.Game;
import com.scaler.lld.tictactoe.models.GameStatus;
import com.scaler.lld.tictactoe.models.GameSymbol;
import com.scaler.lld.tictactoe.models.HumanPlayer;
import com.scaler.lld.tictactoe.models.Player;
import com.scaler.lld.tictactoe.models.User;
import com.scaler.lld.tictactoe.strategies.RandomPlayingStrategy;

public class TicTactToe {

    public static void main(String[] args) {
        Game game = createGame();

        System.out.println("Game Started");
        
        while (game.getStatus() == GameStatus.IN_PROGRESS) {
            Player nextPlayer = game.getNextPlayer();
            System.out.println("Next Move is of Player " + nextPlayer.getSymbol());

            game.makeMove();

            game.printBoard();

        }

        if (game.getStatus().equals(GameStatus.DRAW)) {
            System.out.println("Game DRAW. No Winner.");
        }

        if (game.getStatus().equals(GameStatus.ENDED)) {
            System.out.println("Game has ended. Winner:");
        }
    }

    private static Game createGame() {

        HumanPlayer human = HumanPlayer
                .builder()
                .symbol(GameSymbol.O)
                .user(new User())
                .build();

        Bot bot = Bot
                .builder()
                .symbol(GameSymbol.X)
                .playingStrategy(new RandomPlayingStrategy())
                .build();

        Game game = Game.getBuilder()
                .withDimension(3, 3)
                .withPlayer(human)
                .withPlayer(bot)
                .build();

        return game;
    }

}
