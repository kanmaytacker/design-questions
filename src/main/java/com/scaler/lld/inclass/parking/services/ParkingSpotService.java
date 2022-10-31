package com.scaler.lld.inclass.parking.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.scaler.lld.inclass.parking.models.ParkingLot;
import com.scaler.lld.inclass.parking.models.ParkingSpot;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ParkingSpotService {

    private ParkingSpotRepository repository;

    public List<ParkingSpot> createSpots(ParkingLot parkingLot) {
        List<ParkingSpot> parkingSpots = parkingLot
                .getFloors()
                .stream()
                .flatMap(floor -> floor.getParkingSpots().stream())
                .collect(Collectors.toList());
        return repository.saveAll(parkingSpots);
    }

}

// [[1, 2], [3, 4]] -> [1, 2, 3, 4] -> Flattening
// .filter/.map -> Iterable
// .stream -> parallelStream