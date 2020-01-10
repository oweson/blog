package com.zyd.blog.controller.third_party_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyd.blog.controller.third_party_service.response.WeatherResponse;
import com.zyd.blog.controller.third_party_service.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2020/1/10 22:51
 */
/**RedisTemplate和StringRedisTemplate的区别：

 1. 两者的关系是StringRedisTemplate继承RedisTemplate。

 2. 两者的数据是不共通的；也就是说StringRedisTemplate只能管理StringRedisTemplate里面的数据，RedisTemplate只能管理RedisTemplate中的数据。

 3. SDR默认采用的序列化策略有两种，一种是String的序列化策略，一种是JDK的序列化策略。

 StringRedisTemplate默认采用的是String的序列化策略，保存的key和value都是采用此策略序列化保存的。

 RedisTemplate默认采用的是JDK的序列化策略，保存的key和value都是采用此策略序列化保存的。
 ————————————————
 版权声明：本文为CSDN博主「易樊」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 原文链接：https://blog.csdn.net/yifansj/article/details/79513179*/
@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);
    private final String WEATHER_API = "http://wthrcdn.etouch.cn/weather_mini";
    /**
     *     * 缓存超时时间
     *    
     */
    private final Long TIME_OUT = 1800L;
    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_API + "?citykey=" + cityId;
        return this.doGetWeatherData(uri);
    }
    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_API + "?city=" + cityName;
        return this.doGetWeatherData(uri);
    }
    private WeatherResponse doGetWeatherData(String uri) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        //将调用的uri作为缓存的key
        String strBody = null;
        //先查缓存，没有找到查服务
        if (!stringRedisTemplate.hasKey(uri)) {
            logger.info("未找到 key " + uri);
            ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
            if (response.getStatusCodeValue() == 200) {
                strBody = response.getBody();
            }
            ops.set(uri, strBody, TIME_OUT, TimeUnit.SECONDS);
        } else {
            logger.info("找到 key " + uri + ",value=" + ops.get(uri));
            strBody = ops.get(uri);
        }
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weather = null;
        try {
            weather = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weather;
    }

}
