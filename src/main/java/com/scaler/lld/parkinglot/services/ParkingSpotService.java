package com.scaler.lld.parkinglot.services;

import com.scaler.lld.parkinglot.models.ParkingSpot;
import com.scaler.lld.parkinglot.repositories.ParkingSpotRepository;

public class ParkingSpotService {

    private ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();

    public void save(ParkingSpot spot) {
        parkingSpotRepository.save(spot);
    }

    public ParkingSpot getParkingSpot(Integer spotId) {
        return parkingSpotRepository.findById(spotId);
    }

}
