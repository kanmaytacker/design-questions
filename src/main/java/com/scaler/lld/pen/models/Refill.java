package com.scaler.lld.pen.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Refill {
    private Boolean refillable;
    private Ink ink;
    private Nib nib;

}
