package com.scaler.lld.inclass.parking.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class Gate extends BaseModel {
    private String location;
    private ParkingAttendant operator;
}
