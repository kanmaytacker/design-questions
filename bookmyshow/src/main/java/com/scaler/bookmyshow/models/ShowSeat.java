package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.SeatStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeat extends BaseModel {
    private Show show;

    private Seat seat;

    private SeatStatus status;

}