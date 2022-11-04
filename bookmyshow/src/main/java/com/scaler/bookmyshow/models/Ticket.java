package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.TicketStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@Getter
public class Ticket extends BaseModel {

    private Show show;

    private User user;

    @Builder.Default
    private List<ShowSeat> seats = new ArrayList<>();

    private Double amount;

    private TicketStatus status;

    private Payment payment;

}
