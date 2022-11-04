package com.scaler.bookmyshow.models;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@Getter
public class Hall extends BaseModel {

    private Integer hallNumber;

    @Builder.Default
    private List<Seat> seats = new ArrayList<>();
}
