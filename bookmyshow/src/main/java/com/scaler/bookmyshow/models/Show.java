package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.Language;
import com.scaler.bookmyshow.enums.MovieFeature;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuperBuilder
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
}
