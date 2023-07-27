package com.scaler.bms.controllers;

import com.scaler.bms.dtos.CreateBookingRequest;
import com.scaler.bms.models.Booking;
import com.scaler.bms.services.BookingService;
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
