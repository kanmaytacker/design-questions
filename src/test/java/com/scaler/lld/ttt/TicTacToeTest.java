package com.scaler.lld.ttt;

import com.scaler.lld.ttt.models.*;
import com.scaler.lld.ttt.stratergies.playing.RandomPlayingStratergy;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TicTacToeTest {

    private static final int BOARD_SIZE = 3;//Screaming case

    @Test
    public void testCreateGame(){
       Game game = Game.builder()
               .withSize(BOARD_SIZE)
               .withPlayer(new HumanPlayer(GameSymbol.O, new User("abc","asdad","as")))
               .withPlayer(new BotPlayer(GameSymbol.X, GameLevel.EASY, new RandomPlayingStratergy()))
               .build();// we can used lombok superBuilder annotation in player humarplayer and bot player to simply its creation too.
        assertEquals("If the game is created it should have 2 players",2,game.getPlayers().size());
    }

    @Test
    public void testCreateBoard(){
        Board board = new Board(3);
        List<BoardCell> firstRow = board.getCells().get(0);
        int colSize = firstRow.size();
        assertEquals("Checking for constructor board column creation ",3,colSize);

        int rowSize = board.getCells().size();
        assertEquals("Checking for constructor board row creation ",3,rowSize);
    }
}
