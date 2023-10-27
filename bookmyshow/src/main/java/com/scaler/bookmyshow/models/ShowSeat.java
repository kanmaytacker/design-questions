package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowSeat extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    @ManyToOne
    private Seat seat;

    @Enumerated
    private SeatStatus status;

}