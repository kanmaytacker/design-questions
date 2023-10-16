package com.scaler.parkinglot.repositories;

import com.scaler.parkinglot.models.ParkingSpot;
import com.scaler.parkinglot.models.SpotStatus;
import com.scaler.parkinglot.models.VehicleType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ParkingSpotRepository {

    private List<ParkingSpot> parkingSpots = new ArrayList<>();

    public ParkingSpot save(ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
        return parkingSpot;
    }

    public ParkingSpot findOneByVehicleTypeAndStatusAvailable(VehicleType type) {

        for (ParkingSpot parkingSpot : parkingSpots) {

            if (parkingSpot.getSpotStatus() == SpotStatus.AVAILABLE && parkingSpot.getVehicleType() == type) {
                return parkingSpot;
            }
        }

        return null;
    }

    public ParkingSpot update(ParkingSpot filledSpot) {

        ParkingSpot currentSpot = parkingSpots
                .stream()
                .filter(spot -> spot.getId().equals(filledSpot.getId()))
                .findFirst()
                .get();

        if (currentSpot == null) {
            throw new RuntimeException("Invalid Parking Spot");
        }

        parkingSpots.remove(currentSpot);
        parkingSpots.add(filledSpot);

        return filledSpot;
    }

    public void saveAll(List<ParkingSpot> spots) {
        System.out.println("Parking Spots: " + spots);
        parkingSpots.addAll(spots);
        System.out.println("Parking Spots: " + parkingSpots);
    }

    public List<ParkingSpot> findAllByParkingLotId(Long id) {
        return parkingSpots;
    }

    public ParkingSpot findOneById(Long id) {
        return parkingSpots
                .stream()
                .filter(spot -> spot.getId().equals(id))
                .findFirst()
                .get();
    }

}