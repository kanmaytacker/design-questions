package com.scaler.lld.inclass.parking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.scaler.lld.inclass.parking.controllers.ParkingLotController;
import com.scaler.lld.inclass.parking.controllers.TicketController;
import com.scaler.lld.inclass.parking.dtos.CreateParkingLotRequest;
import com.scaler.lld.inclass.parking.dtos.CreateTicketRequest;
import com.scaler.lld.inclass.parking.models.ParkingLot;
import com.scaler.lld.inclass.parking.models.ParkingSpot;
import com.scaler.lld.inclass.parking.models.SpotStatus;
import com.scaler.lld.inclass.parking.models.Ticket;
import com.scaler.lld.inclass.parking.models.VehicleType;
import com.scaler.lld.inclass.parking.repositories.ParkingLotRepository;
import com.scaler.lld.inclass.parking.repositories.TicketRepository;
import com.scaler.lld.inclass.parking.services.ParkingLotService;
import com.scaler.lld.inclass.parking.services.ParkingSpotService;
import com.scaler.lld.inclass.parking.services.TicketService;
import com.scaler.lld.inclass.parking.services.VehicleService;

public class ParkingLotTest {

    private ParkingSpotService parkingSpotService;
    private ParkingLotRepository parkingLotRepository;
    private ParkingLotService parkingLotService;
    private ParkingLotController parkingLotController;
    private TicketController ticketController;

    @Before
    public void setup() {
        parkingLotRepository = new ParkingLotRepository();
        parkingSpotService = new ParkingSpotService();
        parkingLotService = new ParkingLotService(parkingLotRepository, parkingSpotService);
        parkingLotController = new ParkingLotController(parkingLotService);
        TicketService ticketService = new TicketService(new VehicleService(), parkingSpotService,
                new TicketRepository());
        ticketController = new TicketController(ticketService);
    }

    @Test
    public void testCreateParkingLot() {

        CreateParkingLotRequest request = createLotRequest();
        ParkingLot actual = parkingLotController.createParkingLot(request);

        assertParkingLot(request, actual);
    }

    @Test
    public void testCreateAndGet() {
        CreateParkingLotRequest request = createLotRequest();
        ParkingLot expected = parkingLotController.createParkingLot(request);

        ParkingLot actual = parkingLotController.getParkingLot(expected.getId());

        assertParkingLot(request, actual);
    }

    @Test
    public void testCreateAndGetSpots() {
        CreateParkingLotRequest request = createLotRequest();
        ParkingLot expected = parkingLotController.createParkingLot(request);

        ParkingLot actual = parkingLotController.getParkingLot(expected.getId());
        List<ParkingSpot> parkingSpots = parkingSpotService.getParkingSpots(actual.getId());

        assertEquals("If parking lot is created, then parking spots should be created",
                request.getNumberOfFloors() * request.getNumberOfSlotsPerFloor(), parkingSpots.size());

    }

    @Test
    public void testAllocation() {
        CreateParkingLotRequest request = createLotRequest();
        ParkingLot lot = parkingLotController.createParkingLot(request);

        ParkingSpot allocatedSlot = parkingSpotService.allocateSlot(lot.getId(), VehicleType.CAR);
        assertNotNull("If parking spots are available, then allocation should be successful", allocatedSlot);
    }

    @Test
    public void testIssueTicket() {
        CreateParkingLotRequest request = createLotRequest();
        ParkingLot lot = parkingLotController.createParkingLot(request);

        Ticket ticket = ticketController.createTicket(
                CreateTicketRequest
                        .builder().parkingLotId(lot.getId())
                        .vehicleNumber("MH-12-AB-1234")
                        .vehicleType(VehicleType.CAR)
                        .entryGateId(1L)
                        .issuerId(1L)
                        .build());

        assertNotNull("If parking spots are available, then allocation should be successful",
                ticket.getParkingSpotId());

        ParkingSpot actual = parkingSpotService.getParkingSpot(ticket.getParkingSpotId());
        assertEquals("If ticket is issued, then parking spot should be allocated", SpotStatus.FILLED,
                actual.getSpotStatus());
    }

    private static CreateParkingLotRequest createLotRequest() {
        return CreateParkingLotRequest
                .builder()
                .id(1L)
                .name("ABC Parking")
                .address("ABC Street")
                .numberOfFloors(2)
                .numberOfSlotsPerFloor(10)
                .numberOfGates(2)
                .build();
    }

    private static void assertParkingLot(CreateParkingLotRequest request, ParkingLot actual) {

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
