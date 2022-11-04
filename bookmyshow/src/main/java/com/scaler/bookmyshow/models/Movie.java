package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.Language;
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
@NoArgsConstructor
@Entity
public class Movie extends BaseModel {

    private String name;
    private Integer duration;
    private Double rating;

    @ElementCollection
    @Enumerated
    private List<Language> languages = new ArrayList<>();

    @ElementCollection
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();

    public Movie(Date createdAt, Date updatedAt, String name, Integer duration,
                 Double rating, List<Language> languages, List<MovieFeature> features) {
        super(createdAt, updatedAt);
        this.name = name;
        this.duration = duration;
        this.rating = rating;
        this.languages = languages;
        this.features = features;
    }
}
