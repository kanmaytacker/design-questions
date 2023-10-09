package com.scaler.lld.kata;

import com.scaler.lld.kata.models.*;
import com.scaler.lld.kata.strategies.playing.RandomPlayingStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TitTacToeTest {

    private static final int BOARD_SIZE = 3; // Screaming case

    @Test
    public void testCreateGame() {

        Game game = Game.builder()
                .withSize(BOARD_SIZE)
                .withPlayer(
                        HumanPlayer.builder()
                                .symbol(GameSymbol.O).user(null)
                                .build()
                )
                .withPlayer(
                        BotPlayer.builder()
                                .symbol(GameSymbol.X)
                                .level(GameLevel.EASY)
                                .playingStrategy(new RandomPlayingStrategy())
                                .build()
                )
                .build();

        assertEquals(2, game.getPlayers().size(),
                "If the game is created, it should have two players."
        );

    }

    @Test
    public void testCreateBoard() {

        Board board = new Board(3);
        int rowSize = board.getCells().size();
        assertEquals(3, rowSize,
                "If the ctor of board is called with n, it should create n rows"
        );

        int columnSize = board.getCells().get(0).size();
        assertEquals(3, columnSize,
                "If the ctor of board is called with n, it should create n columns"
        );
    }
}

// 6:06 - 6:16
// 10:46 - BREAK

