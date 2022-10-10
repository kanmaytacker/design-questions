package com.scaler.lld.pen.abstractclasses;

import com.scaler.lld.pen.models.PenType;
import com.scaler.lld.pen.models.Refill;
import com.scaler.lld.pen.strategies.WritingStrategy;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Pen {
    private String brand;
    private String name;
    private PenType type;
    private Double price;
    private WritingStrategy writingStrategy;

    public void write() {
        writingStrategy.write();
    }

}