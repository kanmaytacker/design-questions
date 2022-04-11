package com.scaler.lld.parkinglot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {
    private String ticketId;
    private Integer amount;
    private String mode;
}