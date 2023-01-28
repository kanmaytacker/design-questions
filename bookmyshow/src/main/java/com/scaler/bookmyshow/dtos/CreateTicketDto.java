package com.scaler.bookmyshow.dtos;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateTicketDto {
    // User Id
    private Long userId;
    private Long showId;

    private List<Long> showSeatIds = new ArrayList<>();

}
