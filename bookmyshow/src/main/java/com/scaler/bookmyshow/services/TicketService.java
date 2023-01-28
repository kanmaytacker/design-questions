package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.dtos.CreateTicketDto;
import com.scaler.bookmyshow.enums.SeatStatus;
import com.scaler.bookmyshow.enums.TicketStatus;
import com.scaler.bookmyshow.exceptions.SeatUnavailableException;
import com.scaler.bookmyshow.models.ShowSeat;
import com.scaler.bookmyshow.models.Ticket;
import com.scaler.bookmyshow.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketService {

    private TicketRepository ticketRepository;
    private ShowSeatService showSeatService;

    private UserService userService;

    public TicketService(@Qualifier("ticket") TicketRepository ticketRepository, ShowSeatService showSeatService, UserService userService) {
        this.ticketRepository = ticketRepository;
        this.showSeatService = showSeatService;
        this.userService = userService;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket createTicket(CreateTicketDto request) {

        // Check for seat availability
        List<ShowSeat> showSeats = showSeatService.getSeats(request.getShowSeatIds());
        checkAvailability(showSeats);

        // Mark the seats as blocked
        showSeatService.lockSeats(showSeats);

        // Create and persist the ticket
        Ticket ticket = new Ticket();
        ticket.setStatus(TicketStatus.PENDING);
        ticket.setUser(userService.getUser(request.getUserId()));
        ticket.setSeats(showSeats);

        return ticketRepository.save(ticket);
    }

    private void checkAvailability(List<ShowSeat> showSeats) {
        // Iterate over seats and check if all are available
        for (ShowSeat seat : showSeats) {
            if (seat.getStatus() != SeatStatus.AVAILABLE) {
                throw new SeatUnavailableException(seat.getId());
            }
        }
    }

    // .all() / .any()
    // .map() -> Statuses -> filter(Available)
}

// Locks - One machine
// Server can run on multiple machines
// Distributed locks
// Transactions
// Isolation Level - Serializable