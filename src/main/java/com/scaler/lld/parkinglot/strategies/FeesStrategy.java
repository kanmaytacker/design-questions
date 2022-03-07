package com.scaler.lld.parkinglot.strategies;

import com.scaler.lld.parkinglot.models.Ticket;

public interface FeesStrategy {
    int calculateFees(Ticket ticket);
}
