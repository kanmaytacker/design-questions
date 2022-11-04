package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.Language;
import com.scaler.bookmyshow.enums.MovieFeature;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@Getter
public class Movie extends BaseModel {

    private String name;
    private Integer duration;
    private Double rating;

    @Builder.Default
    private List<Language> languages = new ArrayList<>();

    @Builder.Default
    private List<MovieFeature> features = new ArrayList<>();


}
