package com.cslink.service;

public interface RedisService {
    void saveLinkedRedis(String articleId);

    void saveViewRedis(Integer articleId);

    void saveViewToDB();
}
