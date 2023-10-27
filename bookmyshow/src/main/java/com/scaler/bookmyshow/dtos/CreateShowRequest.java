package com.scaler.bookmyshow.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CreateShowRequest {
    private Long hallId;
    private Long movieId;
    private Date startTime;
    private Integer duration;
}