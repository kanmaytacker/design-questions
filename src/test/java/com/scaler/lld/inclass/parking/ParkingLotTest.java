package com.scaler.lld.inclass.parking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.scaler.lld.inclass.parking.controllers.ParkingLotController;
import com.scaler.lld.inclass.parking.dtos.CreateLotRequest;
import com.scaler.lld.inclass.parking.models.ParkingLot;
import com.scaler.lld.inclass.parking.repositories.ParkingLotRepository;
import com.scaler.lld.inclass.parking.services.ParkingLotService;
import com.scaler.lld.inclass.parking.services.ParkingSpotRepository;
import com.scaler.lld.inclass.parking.services.ParkingSpotService;

public class ParkingLotTest {

    private ParkingLotController parkingLotController;
    private ParkingLotService parkingLotService;
    private ParkingSpotService parkingSpotService;

    @Before
    public void setUp() {
        parkingSpotService = new ParkingSpotService(new ParkingSpotRepository());
        parkingLotService = new ParkingLotService(new ParkingLotRepository(), parkingSpotService);
        parkingLotController = new ParkingLotController(parkingLotService);
    }

    @Test
    public void testCreateParkingLot() {
        CreateLotRequest request = CreateLotRequest.builder()
                .id(1L)
                .address("221B Baker Street")
                .name("Gringotts")
                .numberOfFloors(2)
                .numberOfGates(5)
                .numberOfSlotsPerFloor(5)
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
