package com.scaler.lld.parkinglot.controllers;

import com.scaler.lld.parkinglot.dtos.GetTicketDTO;
import com.scaler.lld.parkinglot.models.VehicleType;
import com.scaler.lld.parkinglot.services.EntryGateService;

public class EntryGateController {
    EntryGateService entryGateService = new EntryGateService();

    public GetTicketDTO createTicket(VehicleType vehicleType) {
        return entryGateService.createTicket(vehicleType);
    }
}