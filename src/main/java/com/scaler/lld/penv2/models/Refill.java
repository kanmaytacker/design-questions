package com.scaler.lld.penv2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Refill {
    private Ink ink;
    private Nib nib;
    private RefillType type;
}
