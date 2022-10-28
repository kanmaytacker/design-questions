package com.scaler.lld.inclass.parking.dtos;

import java.util.Collections;
import java.util.List;

import com.scaler.lld.inclass.parking.generators.ParkingFloorId;
import com.scaler.lld.inclass.parking.generators.ParkingSpotId;
import com.scaler.lld.inclass.parking.models.EntryGate;
import com.scaler.lld.inclass.parking.models.ExitGate;
import com.scaler.lld.inclass.parking.models.ParkingFloor;
import com.scaler.lld.inclass.parking.models.ParkingLot;
import com.scaler.lld.inclass.parking.models.ParkingSpot;
import com.scaler.lld.inclass.parking.models.PaymentCounter;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateParkingLotRequest {
    private Long id;
    private String name;
    private String address;
    private int numberOfFloors;
    private int numberOfSlotsPerFloor;
    private int numberOfGates;

    public ParkingLot toParkingLot() {

        // Create dummy parking spots and update their ids
        List<ParkingSpot> parkingSpots = Collections.nCopies(numberOfSlotsPerFloor, ParkingSpot.mediumAvailable());
        parkingSpots.forEach(parkingSpot -> parkingSpot.setId(ParkingSpotId.nextId()));

        // Create dummy parking floors and update their ids
        List<ParkingFloor> parkingFloors = Collections.nCopies(numberOfFloors,
                ParkingFloor
                        .builder()
                        .parkingSpots(parkingSpots)
                        .paymentCounter(PaymentCounter.builder().build())
                        .build());
        parkingFloors.forEach(parkingFloor -> parkingFloor.setId(ParkingFloorId.nextId()));

        return ParkingLot
                .builder()
                .id(id)
                .name(name)
                .address(address)
                .floors(parkingFloors)
                .entryGates(Collections.nCopies(numberOfFloors, EntryGate.builder().build()))
                .exitGates(Collections.nCopies(numberOfFloors, ExitGate.builder().build()))
                .build();

    }

}
