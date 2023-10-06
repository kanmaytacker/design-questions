package com.scaler.lld.kata.exceptions;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException(int row, int column) {
        super("The move was invalid: " + row + " " + column );
    }
}
