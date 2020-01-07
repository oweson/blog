package com.zyd.blog.business.service;

import com.zyd.blog.business.entity.ArticleLook;

import java.util.List;

public interface PopularityService {
    /**
     * 1 文章id和访客的数量；
     */
    ArticleLook insert(Long id, int number);

    /**
     * 2 查找文章的ids集合
     */
    List<Long> getRandomArticleIds();

}
