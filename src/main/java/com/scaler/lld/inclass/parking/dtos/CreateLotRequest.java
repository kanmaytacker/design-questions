package com.scaler.lld.inclass.parking.dtos;

import java.util.Collections;
import java.util.List;

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
public class CreateLotRequest {

    private Long id;
    private String name;
    private String address;
    private int numberOfFloors; // 5
    private int numberOfSlotsPerFloor;// 5
    private int numberOfGates; // 2

    // DTO -> Model
    // Prototype pattern
    public ParkingLot toParkingLot() {

        // Number of floors -> Actual floors
        // 5 - [ParkingFloor, ParkingFloor, ParkingFloor, ParkingFloor, ParkingFloor]
        List<ParkingSpot> parkingSpotsPerFloor = Collections.nCopies(
                numberOfSlotsPerFloor,
                ParkingSpot.mediumAvailable());

        parkingSpotsPerFloor.forEach(spot -> spot.setId(1L));

        // Create floors
        List<ParkingFloor> parkingFloors = Collections.nCopies(numberOfFloors,
                ParkingFloor
                        .builder()
                        .parkingSpots(parkingSpotsPerFloor)
                        .paymentCounter(PaymentCounter.builder().build())
                        .build());

        return ParkingLot
                .builder()
                .id(id)
                .name(name)
                .address(address)
                .floors(parkingFloors)
                .entryGates(Collections.nCopies(numberOfGates, EntryGate.builder().build()))
                .exitGates(Collections.nCopies(numberOfGates, ExitGate.builder().build()))
                .build();
    }

}

// 6:26 - 6:30
// 11 PM
