package com.scaler.lld.inclass.parking.services;

import com.scaler.lld.inclass.parking.models.Vehicle;
import com.scaler.lld.inclass.parking.models.VehicleType;

public class VehicleService {

    public Vehicle findOrCreate(String vehicleNumber, VehicleType vehicleType) {
        return Vehicle
                .builder()
                .licenseNumber(vehicleNumber)
                .type(vehicleType)
                .build();
    }

}
