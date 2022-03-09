package com.scaler.lld.bookmyshow.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "SHOW_SEATS")
public class ShowSeat extends Auditable {
    
    @ManyToOne
    private HallSeat hallSeat;

    @ManyToOne
    private Show show;
    
    @ManyToOne
    private Booking booking;
    private boolean occupied;
    
}
