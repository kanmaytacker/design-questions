package com.scaler.lld.inclass.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.scaler.lld.inclass.cache.eviction.EvictionStrategy;
import com.scaler.lld.inclass.cache.interfaces.Cache;

public class InMemoryCache<KEY, VALUE> implements Cache<KEY, VALUE> {

    private Integer capacity;

    private Integer ttl;
    private Map<KEY, VALUE> values = new ConcurrentHashMap<>();

    private EvictionStrategy<KEY> evictionStrategy;

    public InMemoryCache(Integer capacity, Integer ttl, EvictionStrategy<KEY> evictionStrategy) {
        this.capacity = capacity;
        this.ttl = ttl;
    }

    @Override
    public void create(KEY key, VALUE value) {

        if (values.size() >= capacity) {
            KEY keyToRemove = evictionStrategy.evict();
            delete(keyToRemove);
        }

        values.put(key, value);
    }

    @Override
    public VALUE get(KEY key) {
        return values.get(key);
    }

    @Override
    public void update(KEY key, VALUE value) {
        values.put(key, value);
    }

    @Override
    public void delete(KEY key) {
        values.remove(key);
    }

}

// 1. Lock - Slow
// 2. Synchronised - Slow - Block
// 3. Semaphores
// 4. Atomic data types -