package com.scaler.bms.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateBookingRequest {
    private Long userId;
    private Long showId;
    private List<Long> showSeatId = new ArrayList<>();
}
