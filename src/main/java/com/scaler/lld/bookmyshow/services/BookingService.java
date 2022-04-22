package com.scaler.lld.bookmyshow.services;

import java.util.List;

import com.scaler.lld.bookmyshow.dtos.CreateBookingDTO;
import com.scaler.lld.bookmyshow.models.Booking;
import com.scaler.lld.bookmyshow.models.Customer;
import com.scaler.lld.bookmyshow.models.ShowSeat;
import com.scaler.lld.bookmyshow.repositories.interfaces.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private ShowSeatService showSeatService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BookingRepository bookingRepository;

    public Booking bookTicket(CreateBookingDTO bookingRequest) {

        // Validate if booking is open
        if (!bookingRequest.getShow().isShowPending()) {
            throw new RuntimeException("Booking for this movie is closed!");
        }

        boolean isOccupied = checkIfSeatIsOccupied(bookingRequest.getShowSeats());
        // Early returns
        if (isOccupied) {
            throw new RuntimeException("Seat is already booked!");
        }

        // Go ahead and book
        // Mark the seat as FILLED
        for (ShowSeat seat : bookingRequest.getShowSeats()) {
            seat.setOccupied(true);
            showSeatService.save(seat);
        }

        // Create and persist booking
        Customer customer = customerService.getCustomer(bookingRequest.getCustomerId());
        Booking booking = new Booking(customer, bookingRequest.getShow());
        booking.setSeatsBooked(bookingRequest.getShowSeats());
        return bookingRepository.save(booking);
    }

    public boolean checkIfSeatIsOccupied(List<ShowSeat> seats) {
        for (ShowSeat seat : seats) {
            if (showSeatService.isOccupied(seat)) {
                return true;
            }
        }
        return false;
    }

}

