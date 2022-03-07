package com.scaler.lld.parkinglot.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ParkingLot {
    private String address;
    private List<ParkingFloor> floors = new ArrayList<>();
    private List<EntryGate> entryGates = new ArrayList<>();
    private List<ExitGate> exitGates = new ArrayList<>();
}
