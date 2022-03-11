package com.scaler.lld.bookmyshow.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "BOOKINGS")
public class Booking extends Auditable {
    
    @ManyToOne
    private Customer customer;
    
    @ManyToOne
    private Show show;
    private BookingStatus status;

    @OneToMany(mappedBy = "booking")
    List<ShowSeat> seatsBooked = new ArrayList<>();

    public Booking(Customer customer, Show show) {
        this.customer = customer;
        this.show = show;
        this.status = BookingStatus.PAYMENT_PENDING;
    }
}
