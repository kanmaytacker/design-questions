package com.scaler.lld.inclass.parking.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ParkingLot extends BaseModel {

    private String name;
    private String address;

    @Builder.Default
    private List<ParkingFloor> floors = new ArrayList<>();

    @Builder.Default
    private List<EntryGate> entryGates = new ArrayList<>();

    @Builder.Default
    private List<ExitGate> exitGates = new ArrayList<>();
}
