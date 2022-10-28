package com.scaler.lld.inclass.parking.generators;

import java.util.concurrent.atomic.AtomicLong;

public class ParkingFloorId {
    private static AtomicLong idCounter = new AtomicLong();

    public static Long nextId() {
        return idCounter.getAndIncrement();
    }
}
