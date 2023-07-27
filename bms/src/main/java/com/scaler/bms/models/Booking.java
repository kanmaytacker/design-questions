package com.scaler.bms.models;

import com.scaler.bms.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking extends BaseModel {

    @ManyToOne
    private User user;
    @ManyToOne
    private Show show;
    @ManyToMany
    private List<ShowSeat> seats = new ArrayList<>();

    private Double amount;
    private Date bookedAt;

    @Enumerated
    private BookingStatus status;

    @OneToMany
    private List<Payment> payments = new ArrayList<>();
}