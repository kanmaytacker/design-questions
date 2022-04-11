package com.scaler.lld.parkinglot.controllers;

import com.scaler.lld.parkinglot.models.Ticket;
import com.scaler.lld.parkinglot.services.ExitGateService;

public class ExitGateController {
    ExitGateService exitGateService = new ExitGateService();

    public void exitCustomer(Ticket ticket, Integer paymentAccepted) {
        exitGateService.exitCustomer(ticket, paymentAccepted);
    }
}

// Implement exit gate
// Check payment
// Check price from ticket time
// Make slot available