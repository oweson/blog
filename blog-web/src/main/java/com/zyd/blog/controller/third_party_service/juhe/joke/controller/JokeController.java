package com.zyd.blog.controller.third_party_service.juhe.joke.controller;

import com.zyd.blog.controller.third_party_service.juhe.joke.service.JokeService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/joke")
public class JokeController {
    @Autowired
    private JokeService jokeService;

    @RequestMapping("/getRecentJokeList")
    public JSONObject getRecentJokeList(Integer page, Integer pagesize){
        return jokeService.getRecentJokeList(page,pagesize);
    }

}
