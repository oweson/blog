package com.zyd.blog.controller.third_party_service.juhe.dream.service;

import com.zyd.blog.controller.third_party_service.juhe.dream.api.DreamApi;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class DreamServiceImpl implements DreamService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //    @Value("${spring.redis.isopen}")
    private boolean REDIS_IS_OPEN = true;

    @Override
    public JSONObject getDreamInfo(String keyword) {
        String key = "dream" + keyword;
        String str = "";
        JSONObject object = null;
        if (REDIS_IS_OPEN) {
            ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
            //采用redis缓存,先查缓存，如果存在则在缓存中获取
            if (stringRedisTemplate.hasKey(key)) {
                str = ops.get(key);
            } else {
                str = DreamApi.getDreamInfo(keyword);
                ops.set(key, str, 6L, TimeUnit.HOURS);
            }
        } else {
            str = DreamApi.getDreamInfo(keyword);
        }
        object = JSONObject.fromObject(str);
        return object;
    }
}
