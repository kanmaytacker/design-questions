package com.scaler.lld.bookmyshow.controllers;

import java.util.List;

import com.scaler.lld.bookmyshow.dtos.CreateBookingDTO;
import com.scaler.lld.bookmyshow.models.Booking;
import com.scaler.lld.bookmyshow.models.Show;
import com.scaler.lld.bookmyshow.models.ShowSeat;
import com.scaler.lld.bookmyshow.services.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public Booking bookTicket(CreateBookingDTO bookingRequest) {
        return bookingService.bookTicket(bookingRequest);
    }
}
// component scanning -
// Configuration - XML, JAVA declare all your objects i.e. beans
// Path - /controllers
// Component scanning - Annotate your classes as components
// /api/v1/book
// /api/v1/user/:userId/book
// Step 1 - Add @Controller annotation
// Step 2 - Add the prefix using RequestMapping
// Step 3 - Add the required endpoint using RequestMapping