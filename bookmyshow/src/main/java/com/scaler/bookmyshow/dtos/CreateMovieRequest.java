package com.scaler.bookmyshow.dtos;

import com.scaler.bookmyshow.enums.Language;
import com.scaler.bookmyshow.enums.MovieFeature;
import com.scaler.bookmyshow.models.Movie;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Enumerated;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CreateMovieRequest {
    private String name;
    private Double rating;
    private List<Language> languages = new ArrayList<>();
    private List<MovieFeature> features = new ArrayList<>();

    public Movie toMovie() {
        return Movie.builder()
                .name(name)
                .rating(rating)
                .features(features)
                .languages(languages)
                .build();
    }

}
