package com.scaler.parkinglot.controller;

import com.scaler.parkinglot.dtos.CreateParkingLotRequest;
import com.scaler.parkinglot.models.ParkingLot;

public class ParkingLotController {

    private ParkingLotService parkingLotService = new ParkingLotService();
    // Create a parking lot
    // POST

    // 1. Request validation
    // 2. Data transformation
    public ParkingLot createParkingLot(CreateParkingLotRequest request) {
        validate(request);
        ParkingLot parkingLot = transform(request);
        return parkingLotService.create(parkingLot);
    }

    private void validate(CreateParkingLotRequest request) {
        if (request.getNumberOfFloors() < 0) {
            throw new RuntimeException("Invalid number of floors");
        }
    }

    private ParkingLot transform(CreateParkingLotRequest request) {
        return new ParkingLot();
    }
}
