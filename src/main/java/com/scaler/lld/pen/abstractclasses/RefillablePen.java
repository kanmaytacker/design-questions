package com.scaler.lld.pen.abstractclasses;

import com.scaler.lld.pen.models.PenType;
import com.scaler.lld.pen.models.Refill;
import com.scaler.lld.pen.strategies.WritingStrategy;

import lombok.Getter;

@Getter
public abstract class RefillablePen extends Pen {

    private Refill refill;

    public RefillablePen(String brand, String name, PenType type, Double price, WritingStrategy writingStrategy,
            Refill refill) {
        super(brand, name, type, price, writingStrategy);
        this.refill = refill;
    }

    public void changeRefill(Refill refill) {
        if (this.canRefill()) {
            this.refill = refill;
        }
    }

    public abstract Boolean canRefill();

}
