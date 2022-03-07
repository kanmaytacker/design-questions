package com.scaler.lld.parkinglot.dtos;

import java.time.LocalDateTime;

import com.scaler.lld.parkinglot.models.VehicleType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class GetTicketDTO {
    private VehicleType vehicleType;
    private LocalDateTime entryTime;
}
