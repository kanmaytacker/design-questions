package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.Language;
import com.scaler.bookmyshow.enums.MovieFeature;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Show extends BaseModel {

    @ManyToOne
    private Movie movie;

    @Enumerated
    private Language language;

    private Date startTime;

    private Date endTime;

    @ManyToOne
    private Hall hall;

    @ElementCollection
    @Enumerated
    private List<MovieFeature> movieFeatures = new ArrayList<>();

    @OneToMany
    private List<ShowSeat> showSeats = new ArrayList<>();

    public Show(Date createdAt, Date updatedAt, Movie movie, Language language, Date startTime, Date endTime, Hall hall, List<MovieFeature> movieFeatures, List<ShowSeat> showSeats) {
        super(createdAt, updatedAt);
        this.movie = movie;
        this.language = language;
        this.startTime = startTime;
        this.endTime = endTime;
        this.hall = hall;
        this.movieFeatures = movieFeatures;
        this.showSeats = showSeats;
    }
}
