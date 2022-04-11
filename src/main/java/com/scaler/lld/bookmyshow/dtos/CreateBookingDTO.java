package com.scaler.lld.bookmyshow.dtos;

import java.util.ArrayList;
import java.util.List;

import com.scaler.lld.bookmyshow.models.Show;
import com.scaler.lld.bookmyshow.models.ShowSeat;

import lombok.Data;

@Data
public class CreateBookingDTO {
    private Long customerId;
    private Show show;
    private List<ShowSeat> showSeats = new ArrayList<>();
}

// Request validation in controller
// Business validation in service