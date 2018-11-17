package com.repairsystem.config.shiro;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;

public class ShiroRedisCacheManager extends AbstractCacheManager{

    private RedisTemplate<byte[],byte[]> redisTemplate;

    public ShiroRedisCacheManager(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected Cache createCache(String name) throws CacheException {
        return new ShiroRedisCache(redisTemplate,name);
    }
}
