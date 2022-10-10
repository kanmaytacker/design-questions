package com.scaler.lld.pen.abstractclasses;

import com.scaler.lld.pen.models.Ink;
import com.scaler.lld.pen.models.Nib;
import com.scaler.lld.pen.models.PenType;
import com.scaler.lld.pen.strategies.RoughWritingStrategy;

public class FountainPen extends NonRefillablePen {

    public FountainPen(String brand, String name, Double price, Ink ink,
            Nib nib) {
        super(brand, name, PenType.FOUNTAIN, price, new RoughWritingStrategy(), ink, nib);
    }

}
