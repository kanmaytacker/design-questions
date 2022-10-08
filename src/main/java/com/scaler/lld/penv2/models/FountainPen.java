package com.scaler.lld.penv2.models;

import com.scaler.lld.penv2.strategies.SmoothWritingStrategy;

public class FountainPen extends Pen {

    public FountainPen(String name, String brand, Double price) {
        super(name, brand, price, PenType.FOUNTAIN, new SmoothWritingStrategy());
    }

}
