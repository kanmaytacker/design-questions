package com.scaler.lld.tictactoe;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import com.scaler.lld.tictactoe.models.Board;
import com.scaler.lld.tictactoe.models.BoardCell;
import com.scaler.lld.tictactoe.models.Bot;
import com.scaler.lld.tictactoe.models.Game;
import com.scaler.lld.tictactoe.models.GameSymbol;
import com.scaler.lld.tictactoe.models.HumanPlayer;
import com.scaler.lld.tictactoe.models.User;
import com.scaler.lld.tictactoe.strategies.DefaultPlayingStrategy;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {
    
    private Game game;

    @Before
    public void setUp() {
        this.game = createGame();
    }
    
    private Game createGame() {

        Game game = new Game();
        
        Board board = new Board(3, 3);
        game.setBoard(board);

        HumanPlayer human = new HumanPlayer();
        human.setSymbol(GameSymbol.O);
        human.setUser(new User());

        Bot bot = new Bot();
        bot.setPlayingStrategy(new DefaultPlayingStrategy());
        game.setPlayers(Arrays.asList(human, bot));

        return game;
    }

    @Test
    public void testDimensions() {
       
        List<List<BoardCell>> cells = game.getBoard().getCells();
        assertEquals("If board is created, number of rows should be equal to input", 3, cells.size());        

        List<BoardCell> firstRow = cells.get(0);
        assertEquals("If board is created, number of columns should be equal to input", 3, firstRow.size());        

    }
}
