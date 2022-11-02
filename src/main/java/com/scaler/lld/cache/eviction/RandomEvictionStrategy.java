package com.scaler.lld.cache.eviction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.scaler.lld.cache.interfaces.Consumer;
import com.scaler.lld.cache.interfaces.EvictionStrategy;
import com.scaler.lld.cache.models.EventType;

public class RandomEvictionStrategy<KEY, VALUE> implements EvictionStrategy<KEY, VALUE>, Consumer<KEY> {

    private List<KEY> keys = new ArrayList<>();

    @Override
    public KEY evict() {
        int randomIndex = ThreadLocalRandom
                .current()
                .nextInt(keys.size())
                % keys.size();

        return keys.get(randomIndex);
    }

    @Override
    public void notifyChange(EventType eventType, KEY key) {
        if (eventType == EventType.READ) {
            return;
        }

        keys.add(key);
    }

}
