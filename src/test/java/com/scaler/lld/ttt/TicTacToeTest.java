package com.scaler.lld.ttt;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.scaler.lld.ttt.models.BoardCell;
import com.scaler.lld.ttt.models.BotLevel;
import com.scaler.lld.ttt.models.BotPlayer;
import com.scaler.lld.ttt.models.Game;
import com.scaler.lld.ttt.models.GameSymbol;
import com.scaler.lld.ttt.models.HumanPlayer;
import com.scaler.lld.ttt.models.Player;
import com.scaler.lld.ttt.models.User;

public class TicTacToeTest {

    private Game game;

    @Before
    public void setup() {
        this.game = createGame();
    }

    // TODO - Use Factory + Builder pattern
    private Game createGame() {
        Player human = HumanPlayer
                .builder()
                .symbol(GameSymbol.O)
                .user(new User(
                        "Paul Morphy", "morphy@blind.in", new Byte[] {}))
                .build();

        Player bot = new BotPlayer(GameSymbol.X, BotLevel.EASY);
        List<Player> players = new ArrayList<>();
        players.add(human);
        players.add(bot);

        return Game.createGame(players, 3, 3);
    }

    @Test
    public void testDimensions() {
        List<List<BoardCell>> cells = game.getBoard().getCells();
        assertEquals("If board is created, number of rows should be equal to input", 3, cells.size());

        List<BoardCell> firstRow = cells.get(0);
        assertEquals("If board is created, number of rows should be equal to input", 3, firstRow.size());

    }
}
