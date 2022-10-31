package com.scaler.lld.cache.interfaces;

public interface EvictionStrategy<KEY, VALUE> {

    KEY evict();

}
