package com.scaler.lld.pen.models;

import com.scaler.lld.pen.strategies.RefillableStrategy;

public class GelPen extends Pen {

    public GelPen(PenBody body, PenNib nib, PenInk ink, RefillableStrategy strategy) {
        super(body, nib, ink, strategy);
    }

    @Override
    public void write() {
        // TODO Auto-generated method stub

    }

}
