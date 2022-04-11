package com.scaler.lld.bookmyshow.services;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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

    private Lock lock = new ReentrantLock();

    public Booking bookTicket(CreateBookingDTO bookingRequest) {

        // Validate if booking is open
        if (!bookingRequest.getShow().isShowPending()) {
            throw new RuntimeException("Booking for this movie is closed!");
        }

        // Critical section - Check if seat is available and then act by booking it
        // Check if the seat is available

        lock.lock();
        try {
            // ==================== Critical Section Start ============
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
            // ==================== Critical Section END ============
        } finally {
            lock.unlock();
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

// Customer 1 - 11PM Book Ticket Avengers Seat 1
// Customer 2 - 11PM Book Ticket Avengers Seat 1, 2

// Step 1 - Check if seat is occupied

// race condition is check then act
// Locking -- Acquires a lock on a monitor object
// -- Allows the processing of code block
// -- Remove the lock
// Advantages of locking
// 1. Across methods
// 2. Fairness using locks

// Step 1 - .lock()
// Step 2 - Process
// Step 3 - .unlock()
