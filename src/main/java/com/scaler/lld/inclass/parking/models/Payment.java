package com.scaler.lld.inclass.parking.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {
    private Double amount;

    private Long ticketId;
    private Ticket ticket;

    private PaymentType mode;
    private PaymentStatus status;
}