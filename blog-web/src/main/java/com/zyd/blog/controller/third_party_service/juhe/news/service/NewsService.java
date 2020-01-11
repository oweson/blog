package com.zyd.blog.controller.third_party_service.juhe.news.service;

import net.sf.json.JSONObject;

public interface NewsService {
    public JSONObject getNewsList(String keyword);
}
