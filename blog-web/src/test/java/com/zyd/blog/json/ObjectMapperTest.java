package com.zyd.blog.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2020/1/15 23:13
 */
public class ObjectMapperTest {
    @Test
    public void demo1() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String writeValueAsString = objectMapper.writeValueAsString(new User("tom", 24));
        System.out.println(writeValueAsString);
        User user = objectMapper.readValue(writeValueAsString, User.class);
        System.out.println(user);
        Map<String,Object> mapperTestMap = new HashMap<>();
        mapperTestMap.put("a","tom");

    }
}
