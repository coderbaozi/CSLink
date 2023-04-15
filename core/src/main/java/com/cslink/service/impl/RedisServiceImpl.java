package com.cslink.service.impl;

import com.cslink.service.IArticleService;
import com.cslink.service.RedisService;
import com.cslink.utils.RedisCache;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

import static com.cslink.constants.RedisPrefix.ARTICLE_INFO;

@Service
public class RedisServiceImpl implements RedisService {
    @Resource
    RedisCache redisCache;
    @Resource
    IArticleService articleService;
    @Override
    public void saveLinkedRedis(String articleId) {

    }

    @Override
    public void saveViewRedis(Integer articleId) {
        if(redisCache.getCacheMap(ARTICLE_INFO+articleId)!=null) {
            if (redisCache.getCacheMap(ARTICLE_INFO + articleId).get("articleId") == null) {
                redisCache.setCacheMapValue(ARTICLE_INFO + articleId, "articleId", articleId);
            }
            redisCache.incrementHash(ARTICLE_INFO + articleId, "viewCount");
        }
    }

    @Override
    public void saveViewToDB() {
        Set res = redisCache.likeQueryHash(ARTICLE_INFO);
        for (Object item :res) {
            Map<String, Object> map = redisCache.getCacheMap(item.toString());
            articleService.updateBrowseCount((Integer) map.get("articleId"), (Integer) map.get("viewCount"));
        }
    }
}
