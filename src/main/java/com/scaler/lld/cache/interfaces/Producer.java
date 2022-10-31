package com.scaler.lld.cache.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.scaler.lld.cache.models.EventType;

public abstract class Producer<KEY> {

    List<Consumer<KEY>> consumers = new ArrayList<>();

    public void register(Consumer<KEY> consumer) {
        consumers.add(consumer);
    }

    public void deregister(Consumer<KEY> consumer) {
        consumers.remove(consumer);
    }

    public void notifyConsumers(EventType eventType, KEY key) {
        consumers.forEach(consumer -> consumer.notifyChange(eventType, key));
    }

}
