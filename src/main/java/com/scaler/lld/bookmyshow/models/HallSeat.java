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
@Table(name = "HALL_SEATS")
public class HallSeat extends Auditable {

    private String seatLocation;
    private String seatType;
    private boolean isUnderMaintenance;
    
    @ManyToOne
    private CinemaHall cinemaHall;

    @OneToMany(mappedBy = "hallSeat")
    private List<ShowSeat> showSeats = new ArrayList<>();
}
