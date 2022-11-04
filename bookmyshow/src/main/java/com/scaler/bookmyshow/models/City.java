package com.scaler.bookmyshow.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class City extends BaseModel {

    private String name;

    @OneToMany
    private List<Theatre> theatres = new ArrayList<>();

    public City(Date createdAt, Date updatedAt, String name) {
        super(createdAt, updatedAt);
        this.name = name;
    }
}
