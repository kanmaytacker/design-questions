package com.scaler.lld.ttt.exception;

public class InvalidPlayersException extends RuntimeException{
    public InvalidPlayersException() {
        super("Invalid list of players");
    }
}
