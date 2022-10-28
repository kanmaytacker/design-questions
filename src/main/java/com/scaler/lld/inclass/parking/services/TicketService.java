package com.scaler.lld.inclass.parking.services;

import java.time.LocalDateTime;

import com.scaler.lld.inclass.parking.dtos.CreateTicketRequest;
import com.scaler.lld.inclass.parking.models.ParkingSpot;
import com.scaler.lld.inclass.parking.models.SpotStatus;
import com.scaler.lld.inclass.parking.models.Ticket;
import com.scaler.lld.inclass.parking.repositories.TicketRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TicketService {

    private VehicleService vehicleService;
    private ParkingSpotService parkingSpotService;

    private TicketRepository ticketRepository;

    public Ticket createTicket(CreateTicketRequest request) {

        // Check if parking lot is full
        ParkingSpot parkingSpot = parkingSpotService.allocateSlot(request.getParkingLotId(), request.getVehicleType());
        if (parkingSpot == null) {
            throw new RuntimeException("Slot not available!");
        }

        // Update slot status
        parkingSpot.setSpotStatus(SpotStatus.FILLED);

        // Persist slot
        parkingSpotService.update(parkingSpot);

        // Create and persist ticket
        Ticket ticket = Ticket
                .builder()
                .entryTime(LocalDateTime.now())
                .parkingSpotId(parkingSpot.getId())
                .entryGateId(request.getEntryGateId())
                .issuerId(request.getIssuerId())
                .vehicle(vehicleService.findOrCreate(request.getVehicleNumber(), request.getVehicleType()))
                .build();

        return ticketRepository.save(ticket);
    }

}
