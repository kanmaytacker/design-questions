package com.scaler.bookmyshow.models;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@Getter
public class Theatre extends BaseModel {

    private String name;
    private String address;

    @Builder.Default
    private List<Hall> halls = new ArrayList<>();
}
