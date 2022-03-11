package com.scaler.lld.bookmyshow.controllers;

import com.scaler.lld.bookmyshow.dtos.CreateBookingDTO;
import com.scaler.lld.bookmyshow.models.Booking;
import com.scaler.lld.bookmyshow.services.BookingService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public Booking book(@RequestBody CreateBookingDTO bookingRequest) {
        return bookingService.book(bookingRequest);
    }
}
