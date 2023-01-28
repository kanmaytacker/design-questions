package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.dtos.CreateTicketDto;
import com.scaler.bookmyshow.models.Ticket;
import com.scaler.bookmyshow.services.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TicketController {

    private TicketService ticketService;

    // Create a ticket
    // VERB - ENDPOINT
    @PostMapping("/ticket")
    public Ticket createTicket(@RequestBody CreateTicketDto request) {
        return ticketService.createTicket(request);
    }
}
