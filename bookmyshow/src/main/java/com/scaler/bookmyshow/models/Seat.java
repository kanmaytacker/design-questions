package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.SeatType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Seat extends BaseModel {

    private Integer row;
    private Integer column;

    private SeatType type;

}
