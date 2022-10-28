package com.scaler.lld.inclass.parking.services;

import com.scaler.lld.inclass.parking.models.ParkingLot;

public class ParkingLotService {

    private ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

    public ParkingLot createParkingLot(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

    public ParkingLot getParkingLot(Long id) {
        return parkingLotRepository.findById(id);
    }

}
