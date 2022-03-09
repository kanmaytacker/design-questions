package com.scaler.lld.bookmyshow.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Cinema extends Auditable {

    private String name;
    private String address;
    
    @OneToMany(mappedBy = "cinema")
    private List<CinemaHall> halls = new ArrayList<>();
}
