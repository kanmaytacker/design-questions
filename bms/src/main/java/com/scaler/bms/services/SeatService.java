package com.scaler.bms.services;

import com.scaler.bms.models.Seat;
import com.scaler.bms.repositories.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeatService {
    private SeatRepository seatRepository;

    public List<Seat> saveAll(List<Seat> seats) {
        return seatRepository.saveAll(seats);
    }

    public List<Seat> getAll(Long hallId) {
        return seatRepository.findAllByHall_Id(hallId);
    }
}
