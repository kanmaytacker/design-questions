package com.scaler.lld.ttt;

import com.scaler.lld.ttt.exception.InvalidOptionException;
import com.scaler.lld.ttt.exception.InvalidSymbolException;
import com.scaler.lld.ttt.models.*;
import com.scaler.lld.ttt.stratergies.playing.RandomPlayingStratergy;

import java.util.Scanner;

public class TicTacToe {

    public static final int BOARD_SIZE = 3;

    public static void main(String[] args) {
        //Ask for user input --- name, email, symbol
       HumanPlayer human = getUserInput();


        //create game
        Game game = createGame(human);
        game.start();


        //Intialize the bot player
        //H vs B

       //Iteratively call make move till game status in win or draw
        while(game.getStatus() == GameStatus.IN_PROGRESS){
            Player player = game.getNextPlayer();
            System.out.println("Next Player:"+player.getSymbol());
            game.makeMove();
            game.getBoard().printBoard();
        }

        if(game.getStatus() == GameStatus.FINISHED){
            System.out.println("Game won by player :"+game.getWinner().getSymbol());
        }

    }

    private static Game createGame(HumanPlayer human){
        System.out.println("For Human Vs Human enter 1 For Human Vs Bot enter 2:");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        if(option != 1 && option != 2){
            throw new InvalidOptionException();
        }
        if(option == 2) {
            return Game.builder()
                    .withSize(BOARD_SIZE)
                    .withPlayer(human)
                    .withPlayer(
                            BotPlayer.builder()
                                    .playingStratergy(new RandomPlayingStratergy())
                                    .level(GameLevel.EASY)
                                    .symbol(getSymbol(human.getSymbol()))
                                    .build()
                    )
                    .build();
        }else{
            return Game.builder()
                    .withSize(BOARD_SIZE)
                    .withPlayer(human)
                    .withPlayer(
                            getSecondUserInput(human.getSymbol())
                    )
                    .build();
        }
    }

    private static GameSymbol getSymbol(GameSymbol symbol) {
        if(symbol == GameSymbol.O){
            return GameSymbol.X;
        }
        return GameSymbol.O;
    }


    private static HumanPlayer getUserInput() {
        System.out.println("Welcome to TicTacToe");
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter name:");
        String name = scan.nextLine();

        System.out.println("Enter email:");
        String email = scan.nextLine();

        System.out.println("Enter symbol X or O:");
        GameSymbol symbol;
        try {
            symbol = GameSymbol.valueOf(scan.nextLine());
        }catch(IllegalArgumentException e){
            throw new InvalidSymbolException();
        }
        User user = new User(name, email, "");
        return new HumanPlayer(symbol, user);
    }

    private static HumanPlayer getSecondUserInput(GameSymbol firstSymbol) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter name:");
        String name = scan.nextLine();

        System.out.println("Enter email:");
        String email = scan.nextLine();

        User user = new User(name, email, "");
        return new HumanPlayer(getSymbol(firstSymbol), user);
    }
}
