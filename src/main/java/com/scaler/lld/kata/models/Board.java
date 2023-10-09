package com.scaler.lld.kata.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Getter
public class Board {

    private int size;
    private List<List<BoardCell>> cells = new ArrayList<>();

    public Board(int size) {
        this.size = size;
        this.cells = initialiseCells(size);
    }

    private List<List<BoardCell>> initialiseCells(int size) {
        List<List<BoardCell>> cells = new ArrayList<>();
        IntStream.range(0, size).forEach(row -> {
            List<BoardCell> rowCells = new ArrayList<>();
            IntStream.range(0, size).forEach(column -> rowCells.add(new BoardCell(row, column)));
            cells.add(rowCells);
        });
        return cells;
    }

    public boolean isEmpty(int row, int column) {
        return getBoardCell(row, column).getSymbol() == null;
    }

    public void update(BoardCell move) {
        getBoardCell(move.getRow(), move.getColumn()).setSymbol(move.getSymbol());
    }

    private BoardCell getBoardCell(int row, int column) {
        return cells.get(row).get(column);
    }

    public void printBoard() {
        for (int i = 0; i < cells.size(); ++i) {
            for (int j = 0; j < cells.size(); ++j) {
                GameSymbol symbol = cells.get(i).get(j).getSymbol();

                if (symbol == null) {
                    System.out.printf(" | - | ");
                } else {
                    System.out.printf(" | " + symbol + " | ");
                }
            }
            System.out.printf("\n");
        }
    }

    public List<BoardCell> getEmptyCells() {
        // Iterate over the cells
        // Flatten the array 2D => 1D
        // Filter out cells where symbol != null

        // Get a list of streams and combine it into one
        return cells.stream()
                .flatMap(List::stream)
                .filter(cell -> cell.getSymbol() == null)
                .toList();
    }
}
