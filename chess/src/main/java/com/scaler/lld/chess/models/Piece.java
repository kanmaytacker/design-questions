package com.scaler.lld.chess.models;

import com.scaler.lld.chess.enums.Colour;
import com.scaler.lld.chess.enums.PieceStatus;
import com.scaler.lld.chess.enums.PieceType;
import com.scaler.lld.chess.strategies.MovingStrategy;

public class Piece {
    private Colour colour;
    private PieceType type;
    private Cell cell;
    private PieceStatus status;
    private MovingStrategy movingStrategy;

    public boolean canMove(Player player, Board board, Cell target) {
        return movingStrategy.canMove(player, board, target);
    }

    public Move move(Player player, Board board, Cell target) {
        return movingStrategy.move(player, board, target);
    }
}
