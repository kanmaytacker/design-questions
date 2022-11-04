package com.scaler.bookmyshow.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Theatre extends BaseModel {

    private String name;
    private String address;

    @OneToMany
    private List<Hall> halls = new ArrayList<>();

    @OneToMany
    private List<Show> shows = new ArrayList<>();

    public Theatre(Date createdAt, Date updatedAt, String name, String address, List<Hall> halls, List<Show> shows) {
        super(createdAt, updatedAt);
        this.name = name;
        this.address = address;
        this.halls = halls;
        this.shows = shows;
    }
}
