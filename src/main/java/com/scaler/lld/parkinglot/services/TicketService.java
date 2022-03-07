package com.scaler.lld.parkinglot.services;

import java.sql.Date;
import java.time.LocalDateTime;

import com.scaler.lld.parkinglot.models.ParkingSpot;
import com.scaler.lld.parkinglot.models.Ticket;
import com.scaler.lld.parkinglot.models.VehicleType;
import com.scaler.lld.parkinglot.repositories.TicketRepository;

public class TicketService {

    private TicketRepository ticketRepository = new TicketRepository();

    public Ticket createTicket(VehicleType vehicleType, ParkingSpot spot) {

        Ticket ticket = Ticket
                .builder()
                .entryTime(LocalDateTime.now())
                .floorNumber(spot.getFloorNumber())
                .slotNumber(spot.getSpotId())
                .build();

        return ticketRepository.save(ticket);
    }

}