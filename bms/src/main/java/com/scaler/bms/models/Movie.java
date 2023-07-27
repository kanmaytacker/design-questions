package com.scaler.bms.models;

import com.scaler.bms.enums.Language;
import com.scaler.bms.enums.MovieFeature;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity
public class Movie extends BaseModel {
    private String name;
    private Double rating;

    @ElementCollection
    @Enumerated
    private List<Language> languages = new ArrayList<>();

    @ElementCollection
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();

    // Genre -> List<String>
    // Movie ID | Feature
    // 1 | 3D
    // 1 | Dolby
    // 2 | 2D
}