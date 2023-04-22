package com.Geekster.urlHitCounter.controller;

import com.Geekster.urlHitCounter.service.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/visitor-count-app")
public class UrlHitController {
    @Autowired
    private UrlHitService urlHitService;

    @GetMapping("/count")
    public Map<String, Integer> getHitCount() {
        int hitCount = urlHitService.incrementHitCount();
        Map<String, Integer> response = new HashMap<>();
        response.put("count", hitCount);
        return response;
    }

    @GetMapping("/username/{username}/count")
    public Map<String, String> getUserHitCount(@PathVariable String username) {
        int userHitCount = urlHitService.getHitCountByUsername(username);
        Map<String, String> response = new HashMap<>();
        response.put("username", username);
        response.put("hitcount", String.valueOf(userHitCount));
        return response;
    }
}

