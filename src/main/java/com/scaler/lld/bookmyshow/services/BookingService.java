package com.scaler.lld.bookmyshow.services;

import java.util.List;

import com.scaler.lld.bookmyshow.dtos.CreateBookingDTO;
import com.scaler.lld.bookmyshow.models.Booking;
import com.scaler.lld.bookmyshow.models.Customer;
import com.scaler.lld.bookmyshow.models.ShowSeat;
import com.scaler.lld.bookmyshow.repositories.interfaces.BookingRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookingService {
    
    private final ShowSeatService showSeatService;
    private final CustomerService customerService;
    private final BookingRepository bookingRepository;
    
    public Booking book(CreateBookingDTO bookingRequest) {
        
        if (!bookingRequest.getShow().isShowPending()) {
            throw new RuntimeException("The show is no longer accepting bookings");
        }
        
        Booking booking;
        // Acquire some lock
        {
            boolean preOccupied = checkIfOccupied(bookingRequest.getShowSeats());
                    
            if (preOccupied) {
                throw new RuntimeException("Some of the seats are no longer available");
            }
            for (ShowSeat showSeat : bookingRequest.getShowSeats()) {
                showSeat.setOccupied(true);
                showSeatService.book(showSeat);
            }

            Customer customer = customerService.getCustomer(bookingRequest.getCustomerId());
            booking = new Booking(customer, bookingRequest.getShow());
            booking.setSeatsBooked(bookingRequest.getShowSeats());
            bookingRepository.save(booking);
        }
        // todo: release lock
        return booking;
    }

    private boolean checkIfOccupied(List<ShowSeat> showSeats) {
        for (ShowSeat showSeat : showSeats) {
            if (showSeatService.isOccupied(showSeat)) {
                return true;
            }
        }
        return false;
    }
}
