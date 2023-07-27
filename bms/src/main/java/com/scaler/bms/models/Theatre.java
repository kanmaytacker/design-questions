package com.scaler.bms.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel {

    private String name;
    private String address;

    @OneToMany
    private List<Hall> halls = new ArrayList<>();

    @OneToMany
    private List<Show> shows = new ArrayList<>();
}