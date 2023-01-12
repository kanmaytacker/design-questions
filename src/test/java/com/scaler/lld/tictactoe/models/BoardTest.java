package com.scaler.lld.tictactoe.models;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class BoardTest {
    
    @Test
    public void testDimensions() {
        Board board = new Board(3, 3);
        List<List<BoardCell>> cells = board.getCells();
        
        assertEquals("If board is created, number of rows should be equal to input", 3, cells.size());

        List<BoardCell> firstRow = cells.get(0);
        assertEquals("If board is created, number of columns should be equal to input", 3, firstRow.size());

    }

    @Test
    public void testAllUnavailableCells() {
        Board board = new Board(3, 3);
        List<List<BoardCell>> cells = board.getCells();

        // Set all cells to occupied
        cells.stream().flatMap(List::stream).forEach(cell -> cell.setSymbol(GameSymbol.X));

        List<BoardCell> availableCells = board.getAvailableCells();
        assertEquals("If all cells are occupied, available cells should be empty", 0, availableCells.size());
    }

    @Test
    public void testOneAvailableCell() {
        Board board = new Board(3, 3);
        List<List<BoardCell>> cells = board.getCells();

        // Set all cells to occupied
        cells.stream().flatMap(List::stream).forEach(cell -> cell.setSymbol(GameSymbol.X));

        // Set one cell to empty
        cells.get(0).get(0).setSymbol(null);

        
        List<BoardCell> availableCells = board.getAvailableCells();
        assertEquals("If one cell is available, available cells should have one cell", 1, availableCells.size());
    }
}
