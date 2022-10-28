package com.scaler.lld.inclass.parking.services;

import com.scaler.lld.inclass.parking.models.ParkingLot;
import com.scaler.lld.inclass.parking.repositories.ParkingLotRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ParkingLotService {

    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotService parkingSpotService;

    public ParkingLot createParkingLot(ParkingLot parkingLot) {
        ParkingLot persistedLot = parkingLotRepository.save(parkingLot);
        parkingSpotService.createParkingSpots(persistedLot);
        return persistedLot;
    }

    public ParkingLot getParkingLot(Long id) {
        return parkingLotRepository.findById(id);
    }

}
