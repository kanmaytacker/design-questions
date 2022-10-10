package com.scaler.lld.pen.abstractclasses;

import com.scaler.lld.pen.models.PenType;
import com.scaler.lld.pen.models.Refill;
import com.scaler.lld.pen.strategies.SmoothWritingStrategy;

public class GelPen extends RefillablePen {

    public GelPen(String brand, String name, Double price,
            Refill refill) {
        super(brand, name, PenType.GEL, price, new SmoothWritingStrategy(), refill);
    }

    @Override
    public Boolean canRefill() {
        return getRefill().getRefillable();
    }

}
