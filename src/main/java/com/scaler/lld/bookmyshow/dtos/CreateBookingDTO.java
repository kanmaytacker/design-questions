package com.scaler.lld.bookmyshow.dtos;

import java.util.List;

import com.scaler.lld.bookmyshow.models.Show;
import com.scaler.lld.bookmyshow.models.ShowSeat;

import lombok.Data;
import lombok.NonNull;

@Data
public class CreateBookingDTO {
    @NonNull
    private Show show;
    @NonNull
    private List<ShowSeat> showSeats;
    @NonNull
    private Long customerId;
}
