package com.scaler.lld.chess.strategies;

import com.scaler.lld.chess.models.Board;
import com.scaler.lld.chess.models.Cell;
import com.scaler.lld.chess.models.Move;
import com.scaler.lld.chess.models.Player;

public interface MovingStrategy {

    boolean canMove(Player player, Board board, Cell target);

    Move move(Player player, Board board, Cell target);
}
