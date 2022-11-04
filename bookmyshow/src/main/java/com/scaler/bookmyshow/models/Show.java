package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.Language;
import com.scaler.bookmyshow.enums.MovieFeature;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
public class Show extends BaseModel {

    private Movie movie;

    private Language language;

    private Date startTime;

    private Date endTime;

    private Hall hall;

    @Builder.Default
    private List<MovieFeature> movieFeatures = new ArrayList<>();

    @Builder.Default
    private List<ShowSeat> showSeats = new ArrayList<>();

    public Show(Long id, Date createdAt, Date updatedAt, Movie movie, Language language, Date startTime, Date endTime, Hall hall, List<MovieFeature> movieFeatures, List<ShowSeat> showSeats) {
        super(id, createdAt, updatedAt);
        this.movie = movie;
        this.language = language;
        this.startTime = startTime;
        this.endTime = endTime;
        this.hall = hall;
        this.movieFeatures = movieFeatures;
        this.showSeats = showSeats;
    }
}
