package com.scaler.lld.inclass.cache.eviction;

public interface EvictionStrategy<KEY> {

    KEY evict();
}
