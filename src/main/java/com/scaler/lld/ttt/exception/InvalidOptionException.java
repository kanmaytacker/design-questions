package com.scaler.lld.ttt.exception;

public class InvalidOptionException extends RuntimeException{
    public InvalidOptionException(){
        super("Option can either be 1 or 2");
    }
}
