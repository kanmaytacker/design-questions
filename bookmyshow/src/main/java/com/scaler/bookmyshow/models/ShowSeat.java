package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.SeatStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ShowSeat extends BaseModel {

    private Double price;

    @Enumerated
    private SeatStatus status;

    @ManyToOne
    private Seat seat;

    public ShowSeat(Date createdAt, Date updatedAt, Double price, SeatStatus status, Seat seat) {
        super(createdAt, updatedAt);
        this.price = price;
        this.status = status;
        this.seat = seat;
    }
}
