package com.scaler.lld.pen.multipleclasses;

import com.scaler.lld.pen.models.Ink;
import com.scaler.lld.pen.models.Nib;
import com.scaler.lld.pen.models.PenType;
import com.scaler.lld.pen.models.Refill;

import lombok.Getter;

@Getter
public class FountainPen extends Pen {

    private Ink ink;
    private Nib nib;

    public FountainPen(String brand, String name, Double price, Ink ink, Nib nib) {
        super(brand, name, PenType.FOUNTAIN, price);
        this.ink = ink;
        this.nib = nib;
    }

    @Override
    public void write() {
        System.out.println("Writing with Fountain Pen");
    }

    @Override
    public void changeRefill(Refill refill) {
        throw new UnsupportedOperationException("Fountain Pen cannot be refilled");
    }

    public void changeInk(Ink ink) {
        this.ink = ink;
    }

}
