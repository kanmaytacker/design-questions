package com.scaler.lld.inclass.cache;

import static org.junit.Assert.assertEquals;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import com.scaler.lld.inclass.cache.eviction.RandomEvictionStrategy;
import com.scaler.lld.inclass.cache.interfaces.Cache;

public class CacheTest {
    private Cache<String, String> cache;

    @Before
    public void setUp() {
        cache = new InMemoryCache<>(10, 1000, new RandomEvictionStrategy<String>());
    }

    @Test
    public void testCreateAndGet() {
        cache.create("Test", "TestString");
        String actual = cache.get("Test");

        assertEquals("If put is done, the value should be returned", "TestString", actual);
    }

    @Test(expected = RuntimeException.class)
    public void testCacheOverflow() {
        IntStream.range(0, 11)
                .forEach(index -> cache.create(
                        "Test_" + index, "TestString_" + index));
    }

}
