package com.scaler.lld.parkinglot.strategies.dynamic;

import com.scaler.lld.parkinglot.models.VehicleType;
import com.scaler.lld.parkinglot.strategies.FeesCalculationFactory;
import com.scaler.lld.parkinglot.strategies.FeesStrategy;

public class DynamicFeesFactory implements FeesCalculationFactory {

    @Override
    public FeesStrategy getStrategy(VehicleType vehicleType) {
        switch(vehicleType) {
            case SMALL:
                return new SmallVehicleDynamicStrategy();
            case LARGE:
            case MEDIUM:
                throw new RuntimeException("Not implemented");
        }
        
        throw new RuntimeException("Invalid type!");
    }
    
}
