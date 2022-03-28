package com.scaler.lld.pen.models;

import com.scaler.lld.pen.interfaces.Writable;
import com.scaler.lld.pen.strategies.RefillableStrategy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Pen implements Writable {

    private PenBody body;
    private PenNib nib;
    private PenInk ink;
    private RefillableStrategy refillableStrategy;

    public void refill() {
        this.refillableStrategy.refill(this);
    }
}
