package com.scaler.lld.kata;

import com.scaler.lld.kata.exceptions.InvalidSymbolException;
import com.scaler.lld.kata.models.*;
import com.scaler.lld.kata.strategies.playing.RandomPlayingStrategy;

import java.util.Scanner;

// Client code
public class TicTacToe {

    private static final int BOARD_SIZE = 3;

    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe");

        // Ask for user input - name, email and Symbol
        HumanPlayer human = getUserInput();

        // Create a game
        Game game = createGame(human);
        game.start();



        // Iteratively call make move
        // Until -> Game is WON or DRAWN

        while(game.getStatus() == GameStatus.IN_PROGRESS) {
            Player player = game.getNextPlayer();
            System.out.println("Next player: " + player.getSymbol());

            game.makeMove();
            game.getBoard().printBoard();
        }

        // Start playing
        //

        if(game.getStatus() == GameStatus.FINISHED) {
            System.out.println("Game won by player: " + game.getWinner().getSymbol());
        }
    }

    private static Game createGame(HumanPlayer humanPlayer) {
        // Task 1 - To take user input for the type of bot

        // Type of game: H vs H or H vs B
        // Task 2 - Ask user for the type of game
        return Game.builder()
                .withSize(BOARD_SIZE)
                .withPlayer(humanPlayer)
                .withPlayer(
                        BotPlayer.builder()
                                .symbol(decideBotSymbol(humanPlayer.getSymbol()))
                                .level(GameLevel.EASY)
                                .playingStrategy(new RandomPlayingStrategy())
                                .build()
                )
                .build();
    }

    // Get the list of all symbols
    // Filter out the user's symbol
    // Randomly select one from the list
    private static GameSymbol decideBotSymbol(GameSymbol symbol) {
        if (symbol == GameSymbol.O) {
            return GameSymbol.X;
        }

        return GameSymbol.O;
    }

    private static HumanPlayer getUserInput() {

        // Also ask the user for the type of bot

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name");

        String name = scanner.nextLine();

        System.out.println("Enter email");
        String email = scanner.nextLine();

        System.out.println("Enter symbol (O or X):");
        GameSymbol symbol;
        try {
            symbol = GameSymbol.valueOf(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            throw new InvalidSymbolException();
        }
        User user = new User(name, email, null);

        return new HumanPlayer(symbol, user);

    }
}
