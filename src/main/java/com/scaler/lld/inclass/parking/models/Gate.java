package com.scaler.lld.inclass.parking.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Gate extends BaseModel {
    private String location;
    private ParkingAttendant operator;
}
