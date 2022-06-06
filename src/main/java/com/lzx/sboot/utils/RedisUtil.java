package com.lzx.sboot.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Component
public class RedisUtil {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 往redis中缓存数据
     * @param key
     * @param object
     * @return
     */
    public boolean set(String key, Object object){
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.set(key, object);
        return true;
    }

    /**
     * 根据key从redis服务器中获取value值
     * @param key
     * @return
     */
    public Object get(String key){
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }
}
