package com.scaler.lld.tictactoe.strategies;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.scaler.lld.tictactoe.models.Board;
import com.scaler.lld.tictactoe.models.BoardCell;
import com.scaler.lld.tictactoe.models.GameSymbol;

public class RandomPlayingStrategyTest {

    private Board board;

    @Before
    public void setup() {
        board = new Board(3, 3);
    }

    @Test
    public void testOnlyOneValidMove() {
        // Set all cells to occupied
        List<List<BoardCell>> cells = board.getCells();
        cells.stream().flatMap(List::stream).forEach(cell -> cell.setSymbol(GameSymbol.X));

        // Set one cell to empty
        cells.get(0).get(0).setSymbol(null);

        // Test

        RandomPlayingStrategy strategy = new RandomPlayingStrategy();
        BoardCell cell = strategy.play(board);

        assertNotNull("If there is a valid move, cell should not be null", cell);
        assertNull("If there is a valid move, symbol in cell should be null", cell.getSymbol());

        assertEquals("If there is only one valid move, row should be same value", 0, cell.getRow().intValue());
        assertEquals("If there is only one valid move, column should be same value", 0, cell.getColumn().intValue());
        
    }

    
}
