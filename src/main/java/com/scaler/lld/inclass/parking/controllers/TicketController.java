package com.scaler.lld.inclass.parking.controllers;

import com.scaler.lld.inclass.parking.dtos.CreateTicketRequest;
import com.scaler.lld.inclass.parking.models.Ticket;
import com.scaler.lld.inclass.parking.services.TicketService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TicketController {

    private TicketService ticketService;

    public Ticket createTicket(CreateTicketRequest request) {
        return ticketService.createTicket(request);
    }
}
