package com.scaler.lld.inclass.parking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.scaler.lld.inclass.parking.controllers.ParkingLotController;
import com.scaler.lld.inclass.parking.dtos.CreateParkingLotRequest;
import com.scaler.lld.inclass.parking.models.ParkingLot;

public class ParkingLotTest {
    ParkingLotController parkingLotController = new ParkingLotController();

    @Test
    public void testCreateParkingLot() {
        CreateParkingLotRequest request = CreateParkingLotRequest
                .builder()
                .id(1L)
                .name("ABC Parking")
                .address("ABC Street")
                .numberOfFloors(2)
                .numberOfSlotsPerFloor(10)
                .numberOfGates(2)
                .build();

        ParkingLot actual = parkingLotController.createParkingLot(request);
        assertNotNull("If parking lot is created, it should not be null", actual);

        assertEquals("If parking lot is created, it should have same id as requested", request.getId(), actual.getId());

        assertEquals("If parking lot is created, it should have same number of floors as requested",
                request.getNumberOfFloors(), actual.getFloors().size());

        assertEquals("If parking lot is created, it should have same number of slots per floor as requested",
                request.getNumberOfSlotsPerFloor(), actual.getFloors().get(0).getParkingSpots().size());

        assertEquals("If parking lot is created, it should have same number of entry gates as requested",
                request.getNumberOfGates(), actual.getEntryGates().size());
    }
}
