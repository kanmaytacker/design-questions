package com.scaler.lld.snakesladders.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class Game {

    private Integer id;
    private Board board;

    @Builder.Default
    private List<Player> players = new ArrayList<>();

    @Builder.Default
    private List<Dice> dices = new ArrayList<>();

    public int rollDice() {
        
        int rollValue = 0;
        for (Dice dice : this.dices) {
            rollValue += dice.roll();
        }
        
        return rollValue;
    }
}
