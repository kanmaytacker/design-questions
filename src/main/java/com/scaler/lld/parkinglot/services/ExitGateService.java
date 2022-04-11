package com.scaler.lld.parkinglot.services;

import com.scaler.lld.parkinglot.models.ParkingSpot;
import com.scaler.lld.parkinglot.models.SpotStatus;
import com.scaler.lld.parkinglot.models.Ticket;
import com.scaler.lld.parkinglot.models.TicketStatus;

public class ExitGateService {

    FeeCalculatorService feeService = new FeeCalculatorService();
    PaymentService paymentService = new PaymentService();
    ParkingSpotService parkingSpotService = new ParkingSpotService();

    public void exitCustomer(Ticket ticket, Integer paymentAccepted) {

        int actualCost = feeService.calculateFees(ticket);
        TicketStatus ticketStatus = ticket.getStatus();

        // Early return for ticket paid
        if (ticketStatus == TicketStatus.DONE) {
            
            // Get amount already paid
            Integer paid = paymentService.getPaidAmount(ticket.getId());
            Integer totalPaid = paid + paymentAccepted;
            
            if (totalPaid < actualCost) {
                throw new RuntimeException("Pending amount :" + String.valueOf(actualCost - totalPaid));
            }

            // If paid, mark spot available
            checkoutCustomer(ticket);
        }

        // Check if amount accepted is lesser than actual amount
        if (paymentAccepted < actualCost) {
            throw new RuntimeException("Pending amount :" + String.valueOf(actualCost - paymentAccepted));
        }

        checkoutCustomer(ticket);
    }

    private void checkoutCustomer(Ticket ticket) {
        
        // Get spot using spot ID
        ParkingSpot spot = parkingSpotService.getParkingSpot(ticket.getSlotNumber());
        
        // Mark spot available
        spot.setSpotStatus(SpotStatus.AVAILABLE);
        parkingSpotService.save(spot);
    }

}
