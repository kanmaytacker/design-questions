package com.scaler.lld.pen.multipleclasses;

import com.scaler.lld.pen.models.PenType;
import com.scaler.lld.pen.models.Refill;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Pen {
    private String brand;
    private String name;
    private PenType type;
    private Double price;

    public abstract void write();

    public abstract void changeRefill(Refill refill);

}
