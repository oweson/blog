package com.zyd.blog.business.service;

import com.zyd.blog.business.entity.ArticleLook;

public interface PopularityService {
    // 1 文章id和访客的数量；
    public ArticleLook insert(Long id,int number) ;

    }
