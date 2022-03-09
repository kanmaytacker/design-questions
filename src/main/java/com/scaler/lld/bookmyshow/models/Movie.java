package com.scaler.lld.bookmyshow.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "MOVIES")
public class Movie extends Auditable {

    private String name;
    private Integer durationMinutes;
    
    @OneToMany(mappedBy = "movie")
    private List<Show> shows = new ArrayList<>();

}
