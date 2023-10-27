package com.scaler.bookmyshow.dtos;

import com.scaler.bookmyshow.enums.MovieFeature;
import com.scaler.bookmyshow.enums.SeatType;
import lombok.Data;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class CreateHallRequest {
    private String name;
    private List<MovieFeature> features = new ArrayList<>();
    private Map<SeatType, List<SeatPosition>> seatRanges = new HashMap<>();
}