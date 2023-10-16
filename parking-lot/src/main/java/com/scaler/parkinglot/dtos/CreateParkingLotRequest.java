package com.scaler.parkinglot.dtos;


import com.scaler.parkinglot.generators.ParkingFloorId;
import com.scaler.parkinglot.generators.ParkingLotId;
import com.scaler.parkinglot.generators.ParkingSpotId;
import com.scaler.parkinglot.models.*;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class CreateParkingLotRequest {

    private String name;
    private String address;
    private Integer numberOfFloors;
    private Integer numberOfSpotsPerFloor;
    private Integer numberOfEntryGates;
    private Integer numberOfExitGates;

    public ParkingLot toParkingLot() {

        // Create dummy parking spots and update their ids
        List<ParkingSpot> parkingSpots = Collections.nCopies(numberOfSpotsPerFloor, ParkingSpot.mediumAvailable());
        parkingSpots.forEach(parkingSpot -> parkingSpot.setId(ParkingSpotId.nextId()));

        // Create dummy parking floors and update their ids
        List<ParkingFloor> parkingFloors = Collections.nCopies(numberOfFloors,
                ParkingFloor
                        .builder()
                        .spots(parkingSpots)
                        .paymentCounter(PaymentCounter.builder().build())
                        .build());
        parkingFloors.forEach(parkingFloor -> parkingFloor.setId(ParkingFloorId.nextId()));

        System.out.println(parkingFloors.stream().map(floor -> floor.getSpots().size()));
        return ParkingLot
                .builder()
                .id(ParkingLotId.nextId())
                .name(name)
                .address(address)
                .floors(parkingFloors)
                .entryGates(Collections.nCopies(numberOfEntryGates, EntryGate.builder().build()))
                .exitGates(Collections.nCopies(numberOfExitGates, ExitGate.builder().build()))
                .build();

    }
}

