package com.scaler.bms.services;

import com.scaler.bms.dtos.CreateBookingRequest;
import com.scaler.bms.enums.BookingStatus;
import com.scaler.bms.enums.SeatStatus;
import com.scaler.bms.models.Booking;
import com.scaler.bms.models.Show;
import com.scaler.bms.models.ShowSeat;
import com.scaler.bms.models.User;
import com.scaler.bms.repositories.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class BookingService {

    private BookingRepository bookingRepository;
    private UserService userService;
    private ShowService showService;
    private ShowSeatService showSeatService;

    // A  - 1, 2
    // B - 2, 3
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(CreateBookingRequest request) {

        // Step 1 - Get the user through ID
        // Step 1b) -If user is not present, throw error
        User user = userService.getUserInternal(request.getUserId());
        if (user == null) {
            throw new NoSuchElementException("Invalid user ID: " + request.getUserId());
        }
        // Step 2 - Get the show using show ID
        // Step 2b) -If show is not present, throw error
        Show show = showService.getShow(request.getShowId());

        // Step 3 - Get the show seats using showSeat IDs
        // Step 4 - Check if all the seats are available
        List<ShowSeat> showSeats = showSeatService.getShowSeats(request.getShowSeatId());
        for (ShowSeat seat : showSeats) {
            if (seat.getStatus() != SeatStatus.AVAILABLE) {
                throw new InvalidParameterException("Seat is not available");
            }
        }

        // Step 5 - Mark all the seats blocked
        for (ShowSeat seat : showSeats) {
            seat.setStatus(SeatStatus.LOCKED);
        }
        List<ShowSeat> savedSeats = showSeatService.saveAll(showSeats);

        // Step 6 - Calculate the amount
        // I can have multiple ways of calculating an amount
        // Which design pattern should I use?
        // Strategy - PriceCalculatorStrategy
        Double amount = null;

        // Step 7 - Create and save the booking
        Booking booking = Booking.builder()
                .user(user)
                .show(show)
                .seats(savedSeats)
                .amount(amount)
                .status(BookingStatus.PENDING)
                .bookedAt(new Date())
                .build();
        return bookingRepository.save(booking);
    }
}
