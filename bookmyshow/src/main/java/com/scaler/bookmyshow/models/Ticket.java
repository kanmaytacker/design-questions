package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.TicketStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Ticket extends BaseModel {

    @ManyToOne
    private Show show;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<ShowSeat> seats = new ArrayList<>();

    private Double amount;

    @Enumerated
    private TicketStatus status;

    @OneToOne
    private Payment payment;

    public Ticket(Date createdAt, Date updatedAt, Show show, User user, List<ShowSeat> seats, Double amount, TicketStatus status, Payment payment) {
        super(createdAt, updatedAt);
        this.show = show;
        this.user = user;
        this.seats = seats;
        this.amount = amount;
        this.status = status;
        this.payment = payment;
    }
}
