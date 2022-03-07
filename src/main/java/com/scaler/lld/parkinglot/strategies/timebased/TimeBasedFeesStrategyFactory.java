package com.scaler.lld.parkinglot.strategies.timebased;

import com.scaler.lld.parkinglot.models.Vehicle;
import com.scaler.lld.parkinglot.models.VehicleType;
import com.scaler.lld.parkinglot.strategies.FeesStrategy;

public class TimeBasedFeesStrategyFactory {

    public static FeesStrategy getStrategy(VehicleType vehicleType) {
        
        switch (vehicleType) {
            case LARGE:
                return new LargeVehicleTimeStrategy();
            case MEDIUM:
                return new MediumVehicleTimeStrategy();
            case SMALL:
                return new SmallVehicleTimeStrategy();
        }

        throw new RuntimeException("Invalid type");
    }
}
