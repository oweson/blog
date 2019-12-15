package com.zyd.blog.service;

import com.zyd.blog.BaseJunitTest;
import com.zyd.blog.business.service.PopularityService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PopularityServiceTest extends BaseJunitTest {
    public static final Long articleId = 16L;
    public static final int number = 121;

    static {

    }

    @Before
    public void ininTest() {

    }

    @Autowired
    private PopularityService popularityService;

    @Test
    public void setPopularityServiceTest() {
        popularityService.insert(articleId,number);
    }
}
