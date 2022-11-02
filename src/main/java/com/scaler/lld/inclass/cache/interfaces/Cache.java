package com.scaler.lld.inclass.cache.interfaces;

public interface Cache<KEY, VALUE> {

    void create(KEY key, VALUE value);

    VALUE get(KEY key);

    void update(KEY key, VALUE value);

    void delete(KEY key);

}

// Create a cache with string key and integer values
// new Cache<String, Integer>
// new Cache<Integer, Integer>
// 1. Class level definition
// 2. Data type declaration
