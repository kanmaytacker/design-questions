package com.scaler.lld.pen.multipleclasses;

import com.scaler.lld.pen.models.PenType;
import com.scaler.lld.pen.models.Refill;

import lombok.Getter;

@Getter
public class GelPen extends Pen {

    public GelPen(String brand, String name, Double price, Refill refill) {
        super(brand, name, PenType.GEL, price);
        this.refill = refill;
    }

    private Refill refill;

    @Override
    public void write() {
        System.out.println("Writing with Gel Pen");
    }

    @Override
    public void changeRefill(Refill refill) {
        if (this.refill.getRefillable()) {
            this.refill = refill;
        }
    }

}
