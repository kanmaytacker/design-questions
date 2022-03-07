package com.scaler.lld.parkinglot.services;

import com.scaler.lld.parkinglot.models.ParkingSpot;
import com.scaler.lld.parkinglot.repositories.ParkingSpotRepository;

public class ParkingSpotService {

    private ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();

    public void markSlotBooked(ParkingSpot spot) {
        parkingSpotRepository.save(spot);
    }

}
