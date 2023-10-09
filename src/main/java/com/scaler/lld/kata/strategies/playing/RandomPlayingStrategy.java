package com.scaler.lld.kata.strategies.playing;

import com.scaler.lld.kata.models.Board;
import com.scaler.lld.kata.models.BoardCell;

import java.util.List;

public class RandomPlayingStrategy implements PlayingStrategy {
    @Override
    public BoardCell makeMove(Board board) {
        // Get the available cells
        List<BoardCell> availableCells = board.getAvailableCells();

        // Generate a random number with the size of the available cells
        int randomIndex = (int) (Math.random() * availableCells.size());

        // Return the random cell
        BoardCell randomCell = availableCells.get(randomIndex);
        return new BoardCell(randomCell.getRow(), randomCell.getColumn());
    }
}
