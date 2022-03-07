package com.scaler.lld.parkinglot.strategies;

import com.scaler.lld.parkinglot.models.VehicleType;

public interface FeesCalculationFactory {
    public FeesStrategy getStrategy(VehicleType vehicleType);
}
