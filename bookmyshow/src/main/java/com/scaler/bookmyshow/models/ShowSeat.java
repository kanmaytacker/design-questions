package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.SeatStatus;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ShowSeat extends BaseModel {

    private Double price;

    private SeatStatus status;

    private Seat seat;
}
