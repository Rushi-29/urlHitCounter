package com.Geekster.urlHitCounter.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlHitService {
    private int hitCount = 0;
    private Map<String, Integer> userHitCounts = new HashMap<>();

    public int incrementHitCount() {
        return ++hitCount;
    }

    public int getHitCountByUsername(String username) {
        int count = userHitCounts.getOrDefault(username, 0);
        userHitCounts.put(username, ++count);
        return count;
    }
}
