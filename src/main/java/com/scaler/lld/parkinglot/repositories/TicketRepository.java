package com.scaler.lld.parkinglot.repositories;

import java.util.ArrayList;
import java.util.List;

import com.scaler.lld.parkinglot.models.Ticket;

public class TicketRepository {
    
    private List<Ticket> tickets = new ArrayList<>();

    public Ticket save(Ticket ticket) {
        tickets.add(ticket);
        return ticket;
    }

}
