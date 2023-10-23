package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.MovieFeature;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Screen extends BaseModel {

    private String name;

    private List<Seat> seats = new ArrayList<>();

    private List<MovieFeature> features = new ArrayList<>();

}