package com.scaler.bookmyshow.models;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
public class Theatre extends BaseModel {

    private String name;
    private String address;

    @Builder.Default
    private List<Hall> halls = new ArrayList<>();

    @Builder.Default
    private List<Show> shows = new ArrayList<>();

    public Theatre(Long id, Date createdAt, Date updatedAt, String name, String address, List<Hall> halls, List<Show> shows) {
        super(id, createdAt, updatedAt);
        this.name = name;
        this.address = address;
        this.halls = halls;
        this.shows = shows;
    }
}
