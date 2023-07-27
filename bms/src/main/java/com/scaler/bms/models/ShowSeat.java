package com.scaler.bms.models;

import com.scaler.bms.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // show_seat ==> snake case
public class ShowSeat extends BaseModel {
    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;

    @Enumerated
    private SeatStatus status;

}