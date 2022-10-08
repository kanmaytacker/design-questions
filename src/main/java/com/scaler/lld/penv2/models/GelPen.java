package com.scaler.lld.penv2.models;

import com.scaler.lld.penv2.interfaces.RefillPen;
import com.scaler.lld.penv2.strategies.SmoothWritingStrategy;

public class GelPen extends Pen implements RefillPen {

    public GelPen(String name, String brand, Double price) {
        super(name, brand, price, PenType.GEL, new SmoothWritingStrategy());
    }

    @Override
    public void changeRefill() {

    }

    @Override
    public Refill getRefill() {
        return null;
    }

    @Override
    public Boolean canRefill() {
        return true;
    }

}
