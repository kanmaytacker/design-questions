package com.scaler.parkinglot.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@Getter
public class ParkingFloor extends BaseModel {

    private Integer floorNumber;
    private List<ParkingSpot> spots = new ArrayList<>();

    private DisplayBoard displayBoard;
    private PaymentCounter paymentCounter;

}
