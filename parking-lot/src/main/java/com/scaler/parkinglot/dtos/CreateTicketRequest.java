package com.scaler.parkinglot.dtos;


import com.scaler.parkinglot.models.VehicleType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateTicketRequest {
    private Long parkingLotId;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private Long entryGateId;
    private Long issuerId;
}