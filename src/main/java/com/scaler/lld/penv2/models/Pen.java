package com.scaler.lld.penv2.models;

import com.scaler.lld.penv2.strategies.WritingStrategy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Pen {

    private String name;
    private String brand;
    private Double price;
    private PenType type;

    // Strategy for removing duplication and injecting behavior
    private WritingStrategy writingStrategy;

    public void write() {
        writingStrategy.write();
    }

}

// Finish off implementing a pen
// Factory to create multiple types of pen
// Factory + builder to create a pen
