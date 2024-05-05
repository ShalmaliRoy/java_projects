package com.data.structure;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class LruCache<K,V> extends LinkedHashMap<K,V> {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final int capacity;

    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        return (size() > this.capacity);
    }

    public LruCache(int capacity) {
        super(capacity + 1, 1.0f, true);
        this.capacity = capacity;


    }


    public V find(K key) {
        return super.get(key);
    }


    public void set(K key, V value) {
        super.put(key, value);
    }

    /**
     * Entry point for testing LRU Cache.
     */
    public static void main(String[] args) {
        LruCache<Integer, Integer> cache = new LruCache(
                2);

        cache.set(2, 1);
        cache.set(4, 3);

        System.out.println(cache.find(2));




        cache.set(5, 4);

        System.out.println(cache.find(4));
        System.out.println(cache.find(5));


    }
}
