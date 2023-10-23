package com.scaler.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class City extends BaseModel {

    private String name;

    private List<Theatre> theatres = new ArrayList<>();
}