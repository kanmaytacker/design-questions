package com.scaler.lld.kata;

import com.scaler.lld.kata.models.*;
import com.scaler.lld.kata.strategies.playing.RandomPlayingStrategy;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe");

        Scanner scanner = new Scanner(System.in);
        Game game = createGame(scanner);
        game.start();

        while (game.getStatus() == GameStatus.IN_PROGRESS) {
            Player nextPlayer = game.getNextPlayer();
            System.out.println("Next Move is of Player " + nextPlayer.getSymbol());

            game.makeMove();
            game.getBoard().printBoard();

        }

        if (game.getStatus().equals(GameStatus.DRAWN)) {
            System.out.println("Game DRAW. No Winner.");
        }

        if (game.getStatus().equals(GameStatus.FINISHED)) {
            System.out.println("Game has ended. Winner:" + game.getWinner().getSymbol());
        }
    }

    private static Game createGame(Scanner scanner) {
        // Enter Human player details
        System.out.println("Enter player name:");
        String name = scanner.nextLine();

        System.out.println("Enter player email:");
        String email = scanner.nextLine();

        System.out.println("Enter player symbol:");
        GameSymbol userSymbol = GameSymbol.valueOf(scanner.nextLine());

        User user = new User(name, email, null);

        return Game.builder()
                .withSize(3)
                .withPlayer(
                        HumanPlayer.builder()
                                .symbol(userSymbol).user(user)
                                .build()
                )
                .withPlayer(
                        BotPlayer.builder()
                                .symbol(decideOpponent(userSymbol))
                                .level(GameLevel.EASY)
                                .playingStrategy(new RandomPlayingStrategy())
                                .build()
                )
                .build();


    }

    private static GameSymbol decideOpponent(GameSymbol current) {
        if (current == GameSymbol.O) {
            return GameSymbol.X;
        }

        return GameSymbol.O;
    }

}
