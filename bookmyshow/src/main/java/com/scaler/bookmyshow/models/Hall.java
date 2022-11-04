package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.MovieFeature;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Hall extends BaseModel {

    private Integer hallNumber;

    @ElementCollection
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();

    public Hall(Date createdAt, Date updatedAt, Integer hallNumber) {
        super(createdAt, updatedAt);
        this.hallNumber = hallNumber;
    }
}
