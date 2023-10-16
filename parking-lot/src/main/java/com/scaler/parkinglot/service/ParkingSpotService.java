package com.scaler.parkinglot.service;

import com.scaler.parkinglot.models.ParkingLot;
import com.scaler.parkinglot.models.ParkingSpot;
import com.scaler.parkinglot.models.VehicleType;
import com.scaler.parkinglot.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ParkingSpotService {

    private ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();

    public ParkingSpot allocateSlot(Long parkingLotId, VehicleType vehicleType) {
        return parkingSpotRepository.findOneByVehicleTypeAndStatusAvailable(vehicleType);
    }

    public ParkingSpot update(ParkingSpot filledSpot) {
        return parkingSpotRepository.update(filledSpot);
    }

    public void createParkingSpots(ParkingLot lot) {
        List<ParkingSpot> parkingSpots = lot.getFloors()
                .stream()
                .flatMap(floor -> floor.getSpots().stream())
                .collect(Collectors.toList());
        parkingSpotRepository.saveAll(parkingSpots);
    }

    public List<ParkingSpot> getParkingSpots(Long id) {
        return parkingSpotRepository.findAllByParkingLotId(id);
    }

    public ParkingSpot getParkingSpot(Long id) {
        return parkingSpotRepository.findOneById(id);
    }

}