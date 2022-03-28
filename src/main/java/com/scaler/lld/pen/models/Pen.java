package com.scaler.lld.pen.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Pen {

    private PenBody body;
    private PenNib nib;
    private PenInk ink;

    public abstract void write();
    public abstract void refill();
    
}
