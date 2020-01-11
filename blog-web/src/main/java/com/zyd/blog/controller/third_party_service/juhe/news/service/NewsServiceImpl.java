package com.zyd.blog.controller.third_party_service.juhe.news.service;

import com.zyd.blog.controller.third_party_service.juhe.news.api.NewsApi;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    @Value("${spring.redis.isopen}")
    private boolean REDIS_IS_OPEN=true;

    @Override
    public JSONObject getNewsList(String keyword) {
        String key="dream"+keyword;
        String str="";
        JSONObject object=null;
        if(REDIS_IS_OPEN){
            ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
            //采用redis缓存,先查缓存，如果存在则在缓存中获取
            if(stringRedisTemplate.hasKey(key)) {
                str = ops.get(key);
            }else{
                str= NewsApi.getNewsList(keyword);
                ops.set(key,str,6L, TimeUnit.HOURS);
            }
        }else{
            // redis 没有开启每次都查询！！！
            str= NewsApi.getNewsList(keyword);
        }
        object = JSONObject.fromObject(str);
        return object;
    }
}
