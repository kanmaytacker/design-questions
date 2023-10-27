package com.scaler.bookmyshow.strategies;

import com.scaler.bookmyshow.models.Booking;

public interface PricingStrategy {
    Double calculatePrice(Booking booking);
}
