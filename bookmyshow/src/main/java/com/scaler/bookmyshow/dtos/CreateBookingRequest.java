package com.scaler.bookmyshow.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateBookingRequest {
    private Long customerId;
    private Long showId;
    private List<Long> showSeatsId = new ArrayList<>();
}