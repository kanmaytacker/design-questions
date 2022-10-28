package com.scaler.lld.parkinglot.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EntryGate extends Gate {
    private DisplayBoard displayBoard;
}