package com.scaler.lld.bookmyshow.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CinemaHall extends Auditable {

    private String hallNumber;
    private Integer seatCount;
    
    @ManyToOne
    private Cinema cinema;
    
    @OneToMany(mappedBy = "cinemaHall")
    private List<HallSeat> hallSeats = new ArrayList<>();
    @OneToMany(mappedBy = "cinemaHall")
    private List<Show> shows = new ArrayList<>();
}
