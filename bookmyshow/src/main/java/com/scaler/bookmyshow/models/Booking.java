package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.BookingStatus;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking extends BaseModel {

    private User user;
    private Show show;
    private List<ShowSeat> seats = new ArrayList<>();

    private Double amount;
    private Date bookedAt;

    private BookingStatus status;

    private List<Payment> payments = new ArrayList<>();
}