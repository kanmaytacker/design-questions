package com.scaler.lld.kata.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Board {

    private int size;
    private List<List<BoardCell>> cells = new ArrayList<>();

    public Board(int size) {
        this.size = size;
        this.cells = initialiseCells(size);
    }

    private List<List<BoardCell>> initialiseCells(int size) {
        // From int 3 -> [], [], []
        //               [], [], []
        //               [], [], []

        // Create the first row
        List<BoardCell> firstRow = Collections.nCopies(size, new BoardCell());
        return Collections.nCopies(size, firstRow);
    }

    public boolean isEmpty(int row, int column) {
        new Bo
        return getBoardCell(row, column).getSymbol() == null;
    }

    public void update(BoardCell move) {

        int row = move.getRow();
        int column = move.getColumn();

        BoardCell cell = getBoardCell(row, column);
        cell.setRow(row);
        cell.setColumn(column);
        cell.setSymbol(move.getSymbol());
    }

    private BoardCell getBoardCell(int row, int column) {
        return cells.get(row).get(column);
    }
}
