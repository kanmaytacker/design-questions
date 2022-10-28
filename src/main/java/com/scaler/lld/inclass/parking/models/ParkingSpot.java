package com.scaler.lld.inclass.parking.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ParkingSpot extends BaseModel {
    private Integer floorNumber;
    private SpotType spotType;
    private SpotStatus spotStatus;
}
