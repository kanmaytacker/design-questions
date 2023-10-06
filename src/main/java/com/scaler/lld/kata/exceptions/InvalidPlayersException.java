package com.scaler.lld.kata.exceptions;

public class InvalidPlayersException extends RuntimeException {
    public InvalidPlayersException() {
        super("Invalid list of players!");
    }
}
