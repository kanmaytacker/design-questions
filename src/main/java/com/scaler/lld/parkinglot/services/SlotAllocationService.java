package com.scaler.lld.parkinglot.services;

import com.scaler.lld.parkinglot.models.ParkingSpot;
import com.scaler.lld.parkinglot.models.VehicleType;
import com.scaler.lld.parkinglot.repositories.ParkingSpotRepository;

public class SlotAllocationService {
    
    private ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();

    public ParkingSpot allocateSlot(VehicleType vehicleType) {
        return parkingSpotRepository.findOneByVehicleTypeAndStatusAvailable(vehicleType);
    }

}