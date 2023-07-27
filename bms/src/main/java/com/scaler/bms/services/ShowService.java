package com.scaler.bms.services;

import com.scaler.bms.dtos.CreateShowRequest;
import com.scaler.bms.models.Hall;
import com.scaler.bms.models.Movie;
import com.scaler.bms.models.Show;
import com.scaler.bms.models.ShowSeat;
import com.scaler.bms.repositories.ShowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ShowService {

    private HallService hallService;
    private ShowRepository showRepository;

    public Show createShow(CreateShowRequest request) {

        Hall hall = hallService.getHall(request.getHallId());

        // Task 1 Get the movie ID by calling MovieService
        Movie movie = null;

        Show show = Show
                .builder()
                .hall(hall)
                .startTime(request.getStartTime())
                .duration(request.getDuration())
                .movie(movie)
                .build();

        Show savedShow = showRepository.save(show);

        // Task 2
        // Get the seats in the hall using HallId
        // Create the showSeats using the savedShow
        List<ShowSeat> seats = Collections.emptyList();

        // Save the show seats

        // Save the show again
        return showRepository.save(savedShow.toBuilder().showSeats(seats).build());
    }

    public Show getShow(Long id) {
        return showRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Invalid show ID:" + id));
    }
}
// 6:11 - 6:20 - Break
//      - 10:50 IST
// After break - Create show, Create booking, Encrypting password
