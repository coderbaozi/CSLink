package com.cslink.controller;

import com.cslink.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class CoreController {
    @Autowired
    RedisCache redisCache;
    @GetMapping("/core")
    public String coreTest() {
        return "Hi! Core";
    }

    @GetMapping("/redis")
    public String redisTest() {
        redisCache.setCacheObject("hiRedis",1);
        Integer res = redisCache.getCacheObject("hiRedis");
        redisCache.deleteObject("hiRedis");
        return res.toString();
    }
}
