package com.scaler.lld.snakesladders.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class GameRequest {

    private Integer boardSize;

    @Builder.Default
    List<Player> players = new ArrayList<>();

    @Builder.Default
    List<Dice> dices = new ArrayList<>();
    
    @Builder.Default
    List<Cell> specialCells = new ArrayList<>();
}
