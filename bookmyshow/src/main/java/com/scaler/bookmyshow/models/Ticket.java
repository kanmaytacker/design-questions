package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.TicketStatus;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
public class Ticket extends BaseModel {

    private Show show;

    private User user;

    private List<ShowSeat> seats = new ArrayList<>();

    private Double amount;

    private TicketStatus status;

    private Payment payment;

    public Ticket(Long id, Date createdAt, Date updatedAt, Show show, User user, List<ShowSeat> seats, Double amount, TicketStatus status, Payment payment) {
        super(id, createdAt, updatedAt);
        this.show = show;
        this.user = user;
        this.seats = seats;
        this.amount = amount;
        this.status = status;
        this.payment = payment;
    }
}
