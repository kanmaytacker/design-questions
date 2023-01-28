package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.enums.SeatStatus;
import com.scaler.bookmyshow.models.ShowSeat;
import com.scaler.bookmyshow.repositories.ShowSeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShowSeatService {

    private ShowSeatRepository showSeatRepository;

    public List<ShowSeat> getSeats(List<Long> showSeatIds) {
        return showSeatRepository.findAllById(showSeatIds);
    }

    public void lockSeats(List<ShowSeat> showSeats) {
        for (ShowSeat seat : showSeats) {
            seat.setStatus(SeatStatus.LOCKED);
        }
        showSeatRepository.saveAll(showSeats);
    }
}
