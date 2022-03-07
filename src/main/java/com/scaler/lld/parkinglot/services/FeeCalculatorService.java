package com.scaler.lld.parkinglot.services;

import com.scaler.lld.parkinglot.models.Ticket;
import com.scaler.lld.parkinglot.strategies.FeesStrategy;
import com.scaler.lld.parkinglot.strategies.timebased.TimeBasedFeesStrategyFactory;

public class FeeCalculatorService {
    
    public int calculateFees(Ticket ticket) {
        FeesStrategy feesStrategy = TimeBasedFeesStrategyFactory.getStrategy(ticket.getVehicleType());
        return feesStrategy.calculateFees(ticket);
    }
}
