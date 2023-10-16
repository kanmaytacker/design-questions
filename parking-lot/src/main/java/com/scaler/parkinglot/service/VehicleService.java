package com.scaler.parkinglot.service;

import com.scaler.parkinglot.models.Vehicle;
import com.scaler.parkinglot.models.VehicleType;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    public Vehicle findOrCreate(String vehicleNumber, VehicleType vehicleType) {
        return Vehicle
                .builder()
                .licenseNumber(vehicleNumber)
                .type(vehicleType)
                .build();
    }

}