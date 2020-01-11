package com.zyd.blog.controller.third_party_service.juhe.news.controller;

import com.zyd.blog.controller.third_party_service.juhe.news.service.NewsService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping("/getNewsList")
    public JSONObject getNewsList(String keyword){
        return newsService.getNewsList(keyword);
    }


}
