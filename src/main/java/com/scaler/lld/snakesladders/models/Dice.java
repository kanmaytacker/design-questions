package com.scaler.lld.snakesladders.models;

import lombok.Data;

@Data
public class Dice {
    private Integer faces;

    public int roll() {
        return (int) (Math.random() * faces) + 1;
    }
}
