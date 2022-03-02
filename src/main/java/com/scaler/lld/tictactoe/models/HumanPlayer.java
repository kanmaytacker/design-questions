package com.scaler.lld.tictactoe.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class HumanPlayer extends Player {

    private User user;

    @Override
    public BoardCell play(Board board) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
