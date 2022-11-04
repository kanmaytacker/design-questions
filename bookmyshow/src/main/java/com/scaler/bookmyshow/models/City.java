package com.scaler.bookmyshow.models;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@SuperBuilder
public class City extends BaseModel {

    private String name;

    @Builder.Default
    private List<Theatre> theatres = new ArrayList<>();

}
