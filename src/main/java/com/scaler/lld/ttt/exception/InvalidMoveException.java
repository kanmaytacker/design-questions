package com.scaler.lld.ttt.exception;

public class InvalidMoveException extends RuntimeException{
    public InvalidMoveException(int row, int col) {
        super("Invalid move row:"+row+" col:"+col);
    }
}
