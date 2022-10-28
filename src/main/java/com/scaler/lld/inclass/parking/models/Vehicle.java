package com.scaler.lld.inclass.parking.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle extends BaseModel {
    private String licenseNumber;
    private VehicleType type;
}
