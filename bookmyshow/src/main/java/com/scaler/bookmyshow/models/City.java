package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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