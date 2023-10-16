package com.scaler.parkinglot.models;

import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder
public class ParkingFloor extends BaseModel {

    private Integer floorNumber;
    private List<ParkingSpot> spots = new ArrayList<>();

    private DisplayBoard displayBoard;
    private PaymentCounter paymentCounter;

}
