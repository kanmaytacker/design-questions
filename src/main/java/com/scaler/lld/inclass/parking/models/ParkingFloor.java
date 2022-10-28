package com.scaler.lld.inclass.parking.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ParkingFloor extends BaseModel {

    private Integer floorNumber;

    @Builder.Default
    private List<ParkingSpot> parkingSpots = new ArrayList<>();

    private PaymentCounter paymentCounter;
}
