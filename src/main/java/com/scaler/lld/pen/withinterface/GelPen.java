package com.scaler.lld.pen.withinterface;

import com.scaler.lld.pen.interfaces.RefillPen;
import com.scaler.lld.pen.models.PenType;
import com.scaler.lld.pen.models.Refill;
import com.scaler.lld.pen.strategies.SmoothWritingStrategy;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class GelPen extends Pen implements RefillPen {

    private Refill refill;

    public GelPen(String brand, String name, Double price, Refill refill) {
        super(brand, name, PenType.GEL, price, new SmoothWritingStrategy());
        this.refill = refill;
    }

    @Override
    public void changeRefill(Refill refill) {
        if (this.canRefill()) {
            this.refill = refill;
        }
    }

    @Override
    public Boolean canRefill() {
        return getRefill().getRefillable();
    }

    @Override
    public Refill getRefill() {
        return refill;
    }

}