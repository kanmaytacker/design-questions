package com.scaler.lld.inclass.parking.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ParkingSpot extends BaseModel {
    private SpotType spotType;
    private SpotStatus spotStatus;

    public static ParkingSpot mediumAvailable() {
        return ParkingSpot.builder()
                .spotType(SpotType.MEDIUM)
                .spotStatus(SpotStatus.AVAILABLE)
                .build();
    }
}
