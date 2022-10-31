package com.scaler.lld.inclass.parking.repositories;

import java.util.ArrayList;
import java.util.List;

import com.scaler.lld.inclass.parking.models.ParkingLot;

public class ParkingLotRepository {

    private List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingLot save(ParkingLot parkingLot) {

        parkingLots.add(parkingLot);
        return parkingLot;
    }
}
