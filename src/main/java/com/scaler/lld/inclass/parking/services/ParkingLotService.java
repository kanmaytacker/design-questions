package com.scaler.lld.inclass.parking.services;

import com.scaler.lld.inclass.parking.models.ParkingLot;
import com.scaler.lld.inclass.parking.repositories.ParkingLotRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ParkingLotService {

    private ParkingLotRepository repository;
    private ParkingSpotService parkingSpotService;

    public ParkingLot createParkingLot(ParkingLot parkingLot) {
        ParkingLot lot = repository.save(parkingLot);

        // Create parking spots
        parkingSpotService.createSpots(parkingLot);
        return lot;
    }
}

//
