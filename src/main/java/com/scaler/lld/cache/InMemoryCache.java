package com.scaler.lld.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.scaler.lld.cache.interfaces.Cache;
import com.scaler.lld.cache.interfaces.EvictionStrategy;
import com.scaler.lld.cache.interfaces.Producer;
import com.scaler.lld.cache.models.EventType;

public class InMemoryCache<KEY, VALUE> extends Producer<KEY> implements Cache<KEY, VALUE> {

    private Map<KEY, VALUE> cache = new ConcurrentHashMap<>();
    private Integer capacity;
    private EvictionStrategy<KEY, VALUE> evictionStrategy;

    public InMemoryCache(Integer capacity, EvictionStrategy<KEY, VALUE> evictionStrategy) {
        this.capacity = capacity;
        this.evictionStrategy = evictionStrategy;
    }

    @Override
    public VALUE get(KEY key) {
        notifyConsumers(EventType.READ, key);
        return cache.get(key);
    }

    @Override
    public void put(KEY key, VALUE value) {

        if (cache.size() == capacity) {
            KEY keyToEvict = evictionStrategy.evict();
            remove(keyToEvict);
        }

        notifyConsumers(EventType.WRITE, key);
        cache.put(key, value);
    }

    @Override
    public void remove(KEY key) {
        notifyConsumers(EventType.DELETE, key);
        cache.remove(key);
    }

    Map<KEY, VALUE> getCache() {
        return cache;
    }

}
