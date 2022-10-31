package com.scaler.lld.cache.interfaces;

public interface Cache<KEY, VALUE> {

    VALUE get(KEY key);

    void put(KEY key, VALUE value);

    void remove(KEY key);

}
