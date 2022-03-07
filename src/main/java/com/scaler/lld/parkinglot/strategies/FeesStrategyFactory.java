package com.scaler.lld.parkinglot.strategies;

import com.scaler.lld.parkinglot.strategies.dynamic.DynamicFeesFactory;
import com.scaler.lld.parkinglot.strategies.timebased.TimeBasedFeesStrategyFactory;

public class FeesStrategyFactory {
    
    public static FeesCalculationFactory getFactory(String pricingScheme){
        
        switch(pricingScheme) {
            case "TimeBased":
                return new TimeBasedFeesStrategyFactory();
            case "Dynamic":
                return new DynamicFeesFactory();
        }

        throw new RuntimeException();
    }
}
