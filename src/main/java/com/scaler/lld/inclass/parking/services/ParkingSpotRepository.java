package com.scaler.lld.inclass.parking.services;

import java.util.ArrayList;
import java.util.List;

import com.scaler.lld.inclass.parking.models.ParkingSpot;

public class ParkingSpotRepository {
    private List<ParkingSpot> parkingSpots = new ArrayList<>();

    public ParkingSpot save(ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
        return parkingSpot;
    }

    public List<ParkingSpot> saveAll(List<ParkingSpot> parkingSpots) {
        this.parkingSpots.addAll(parkingSpots);
        return parkingSpots;
    }

}
