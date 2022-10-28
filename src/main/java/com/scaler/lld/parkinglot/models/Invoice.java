package com.scaler.lld.parkinglot.models;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Invoice extends BaseModel {
    private String invoiceId;
    private Date exitTime;
    private String ticketId;
    private Ticket ticket;
    private double amount;
    private String paymentId;
    private Payment payment;
}
