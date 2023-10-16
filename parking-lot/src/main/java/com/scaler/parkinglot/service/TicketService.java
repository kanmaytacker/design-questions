package com.scaler.parkinglot.service;

import java.util.Date;

import com.scaler.parkinglot.dtos.CreateTicketRequest;
import com.scaler.parkinglot.models.ParkingSpot;
import com.scaler.parkinglot.models.Ticket;
import com.scaler.parkinglot.models.SpotStatus;
import com.scaler.parkinglot.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
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
        parkingSpot.setSpotStatus(SpotStatus.OCCUPIED);

        // Persist slot
        parkingSpotService.update(parkingSpot);

        // Create and persist ticket
        Ticket ticket = Ticket
                .builder()
                .entryTime(new Date())
                .spotId(parkingSpot.getId())
                .entryGateId(request.getEntryGateId())
                .vehicle(vehicleService.findOrCreate(request.getVehicleNumber(), request.getVehicleType()))
                .build();

        return ticketRepository.save(ticket);
    }

}