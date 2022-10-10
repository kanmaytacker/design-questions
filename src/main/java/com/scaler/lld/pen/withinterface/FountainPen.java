package com.scaler.lld.pen.withinterface;

import com.scaler.lld.pen.models.Ink;
import com.scaler.lld.pen.models.Nib;
import com.scaler.lld.pen.models.PenType;
import com.scaler.lld.pen.strategies.SmoothWritingStrategy;

import lombok.Getter;

@Getter
public class FountainPen extends Pen {
    private Ink ink;
    private Nib nib;

    public FountainPen(String brand, String name, Double price, Ink ink, Nib nib) {
        super(brand, name, PenType.GEL, price, new SmoothWritingStrategy());
        this.ink = ink;
        this.nib = nib;
    }

    public void changeInk(Ink ink) {
        this.ink = ink;
    }

}
