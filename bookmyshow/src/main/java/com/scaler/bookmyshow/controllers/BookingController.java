package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.dtos.CreateBookingRequest;
import com.scaler.bookmyshow.models.Booking;
import com.scaler.bookmyshow.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BookingController {

    private BookingService bookingService;
    // Create a booking
    @PostMapping("/booking")
    public Booking createBooking(@RequestBody CreateBookingRequest request) {
        return bookingService.createBooking(request);
    }
}