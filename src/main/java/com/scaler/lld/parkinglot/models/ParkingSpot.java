package com.scaler.lld.parkinglot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSpot extends BaseModel {
    private Integer spotId;
    private Integer floorNumber;
    private VehicleType vehicleType;
    private SpotStatus spotStatus;
}
