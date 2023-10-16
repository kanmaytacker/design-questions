package com.scaler.parkinglot.controller;

import com.scaler.parkinglot.dtos.CreateParkingLotRequest;
import com.scaler.parkinglot.models.ParkingLot;
import com.scaler.parkinglot.service.ParkingLotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/parking-lot")
@RestController
@AllArgsConstructor
public class ParkingLotController {

    private ParkingLotService parkingLotService;
    // Create a parking lot
    // POST

    // 1. Request validation
    // 2. Data transformation
    @PostMapping
    public ParkingLot createParkingLot(@RequestBody CreateParkingLotRequest request) {
        validate(request);
        ParkingLot parkingLot = transform(request);
        return parkingLotService.create(parkingLot);
    }

    private void validate(CreateParkingLotRequest request) {
        if (request.getNumberOfFloors() == null) {
            throw new RuntimeException("Invalid number of floors");
        }
    }

    private ParkingLot transform(CreateParkingLotRequest request) {
        return request.toParkingLot();
    }
}
