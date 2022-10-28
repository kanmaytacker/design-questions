package com.scaler.lld.inclass.parking.models;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Invoice extends BaseModel {

    private Date exitTime;
    private double amount;

    private Long ticketId;
    private Ticket ticket;

    private Long paymentId;
    private Payment payment;
}
