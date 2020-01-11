package com.zyd.blog.controller.third_party_service.juhe.joke.service;

import com.zyd.blog.controller.third_party_service.juhe.joke.api.JokeApi;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * 上述的接口声明中，可以看到JSONObject实现了接口Map，Comparable，这两个接口为java jdk自带的接口
 */
@Service
public class JokeServiceImpl implements JokeService {

    @Override
    public JSONObject getRecentJokeList(Integer page, Integer pagesize) {
        String str = JokeApi.getRecentJokeList(page, pagesize);
        JSONObject object = JSONObject.fromObject(str);
        return object;
    }
}
