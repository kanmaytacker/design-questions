package com.scaler.bookmyshow.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
public class Hall extends BaseModel {

    private Integer hallNumber;

    @Builder.Default
    private List<Seat> seats = new ArrayList<>();

    public Hall(Long id, Date createdAt, Date updatedAt, Integer hallNumber) {
        super(id, createdAt, updatedAt);
        this.hallNumber = hallNumber;
    }
}
