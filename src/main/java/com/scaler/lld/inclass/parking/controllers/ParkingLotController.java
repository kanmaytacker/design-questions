package com.scaler.lld.inclass.parking.controllers;

import com.scaler.lld.inclass.parking.dtos.CreateParkingLotRequest;
import com.scaler.lld.inclass.parking.models.ParkingLot;
import com.scaler.lld.inclass.parking.services.ParkingLotService;

public class ParkingLotController {

    private ParkingLotService parkingLotService = new ParkingLotService();

    public ParkingLot createParkingLot(CreateParkingLotRequest request) {
        return parkingLotService.createParkingLot(request.toParkingLot());
    }
}
