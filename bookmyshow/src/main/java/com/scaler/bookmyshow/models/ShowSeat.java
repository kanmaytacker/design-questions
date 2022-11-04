package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.SeatStatus;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
public class ShowSeat extends BaseModel {

    private Double price;

    private SeatStatus status;

    private Seat seat;

    public ShowSeat(Long id, Date createdAt, Date updatedAt, Double price, SeatStatus status, Seat seat) {
        super(id, createdAt, updatedAt);
        this.price = price;
        this.status = status;
        this.seat = seat;
    }
}
