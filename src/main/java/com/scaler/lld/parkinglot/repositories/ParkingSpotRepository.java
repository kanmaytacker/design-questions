package com.scaler.lld.parkinglot.repositories;

import java.util.ArrayList;
import java.util.List;

import com.scaler.lld.parkinglot.models.ParkingSpot;
import com.scaler.lld.parkinglot.models.SpotStatus;
import com.scaler.lld.parkinglot.models.VehicleType;

public class ParkingSpotRepository {
    
    List<ParkingSpot> parkingSpots = new ArrayList<>();

    public ParkingSpot save(ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
        return parkingSpot;
    }

    public ParkingSpot findOneByVehicleTypeAndStatusAvailable(VehicleType type) {
        
        for (ParkingSpot parkingSpot: parkingSpots) {
            
            if (parkingSpot.getSpotStatus() == SpotStatus.AVAILABLE && parkingSpot.getVehicleType() == type){
                return parkingSpot;
            }
        }

        return null;
    }

}