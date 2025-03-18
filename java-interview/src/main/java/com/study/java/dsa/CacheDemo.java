package com.study.java.dsa;

import java.util.HashMap;

class Cache {
    private HashMap<Integer, String> cache = new HashMap<>();

    public String getFromCache(int key) {
        return cache.getOrDefault(key, "Not in cache");
    }

    public void addToCache(int key, String value) {
        cache.put(key, value);
    }
}
/*
 * HashMap stores cached values
 * ✅ O(1) retrieval for fast performance
 * */
public class CacheDemo {
    public static void main(String[] args) {
        Cache cache = new Cache();
        cache.addToCache(1, "Java MVC Example");
        
        System.out.println(cache.getFromCache(1)); // Output: Java MVC Example
        System.out.println(cache.getFromCache(2)); // Output: Not in cache
    }
}
