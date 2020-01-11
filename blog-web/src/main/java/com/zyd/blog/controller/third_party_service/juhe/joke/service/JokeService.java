package com.zyd.blog.controller.third_party_service.juhe.joke.service;


import net.sf.json.JSONObject;

public interface JokeService {
    JSONObject getRecentJokeList(Integer page, Integer pagesize);
}
