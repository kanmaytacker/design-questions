package com.scaler.lld.cache.interfaces;

import com.scaler.lld.cache.models.EventType;

public interface Consumer<KEY> {

    void notifyChange(EventType eventType, KEY key);
}
