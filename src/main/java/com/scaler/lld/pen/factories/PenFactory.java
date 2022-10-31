package com.scaler.lld.pen.factories;

import com.scaler.lld.pen.models.PenType;
import com.scaler.lld.pen.withinterface.GelPen;
import com.scaler.lld.pen.withinterface.Pen;

public class PenFactory {
    public static GelPen.GelPenBuilder createGelPen() {
        return GelPen.builder();
    }

}
