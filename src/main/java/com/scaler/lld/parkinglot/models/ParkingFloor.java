package com.scaler.lld.parkinglot.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingFloor extends BaseModel {
    private Integer floorNumber;
    private String name;
    private List<ParkingSpot> parkingSpots = new ArrayList<>();
}
