package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.Language;
import com.scaler.bookmyshow.enums.MovieFeature;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Movie extends BaseModel {
    private String name;
    private Double rating;

    private List<Language> languages = new ArrayList<>();

    private List<MovieFeature> features = new ArrayList<>();
}