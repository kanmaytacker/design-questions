package com.scaler.lld.bookmyshow.models;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "SHOWS")
public class Show extends Auditable {

    private Date startTime; // include Timezone
    private Date endTime;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private CinemaHall cinemaHall;
    private boolean cancelled;

    @OneToMany(mappedBy = "show")
    private List<Booking> bookings = new ArrayList<>();
    
    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeats = new ArrayList<>();

    public boolean isShowPending() {
        return !cancelled && endTime.after(new Date());
    }

}
