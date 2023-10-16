package com.scaler.parkinglot.models;

import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Date;

@SuperBuilder
public class Ticket extends BaseModel {

    private Vehicle vehicle;

    private Date entryTime;
    private Long spotId;
    private Long entryGateId;
}
