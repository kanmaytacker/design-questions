package com.scaler.lld.pen.abstractclasses;

import com.scaler.lld.pen.models.Ink;
import com.scaler.lld.pen.models.Nib;
import com.scaler.lld.pen.models.PenType;
import com.scaler.lld.pen.strategies.WritingStrategy;

import lombok.Getter;

@Getter
public abstract class NonRefillablePen extends Pen {

    private Ink ink;
    private Nib nib;

    public NonRefillablePen(String brand, String name, PenType type, Double price, WritingStrategy writingStrategy,
            Ink ink, Nib nib) {
        super(brand, name, type, price, writingStrategy);
        this.ink = ink;
        this.nib = nib;
    }

    public void changeInk(Ink ink) {
        this.ink = ink;
    }

}
