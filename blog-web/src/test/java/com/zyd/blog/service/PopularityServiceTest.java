package com.zyd.blog.service;

import com.zyd.blog.BaseJunitTest;
import com.zyd.blog.business.service.PopularityService;
import com.zyd.blog.persistence.mapper.BizArticleMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PopularityServiceTest extends BaseJunitTest {
    @Autowired
    private BizArticleMapper bizArticleMapper;
    public static final Long articleId = 16L;
    public static final int number = 121;
    @Test
    public void tastMapperTest(){
        System.out.println(bizArticleMapper.getArticleIds());
    }

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
    @Test
    public void tastTest(){
        List<Long> randomArticleIds = popularityService.getRandomArticleIds();
        System.out.println(randomArticleIds);

    }
}
