package com.scaler.lld.parkinglot.models;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket extends BaseModel {
    private String ticketId;
    private String vehicleId;
    private VehicleType vehicleType;
    private Integer floorNumber;
    private Integer slotNumber;
    private Date entryTime;
    private Date exitTime;
    private TicketStatus status;
}
