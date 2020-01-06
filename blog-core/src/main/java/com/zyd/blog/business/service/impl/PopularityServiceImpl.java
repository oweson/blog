package com.zyd.blog.business.service.impl;

import com.zyd.blog.business.entity.ArticleLook;
import com.zyd.blog.business.service.PopularityService;
import com.zyd.blog.business.util.IpUtils;
import com.zyd.blog.persistence.beans.BizArticleLook;
import com.zyd.blog.persistence.mapper.BizArticleLookMapper;
import com.zyd.blog.persistence.mapper.BizArticleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class PopularityServiceImpl implements PopularityService {
    @Autowired
    private BizArticleLookMapper bizArticleLookMapper;
    @Autowired
    private BizArticleMapper bizArticleMapper;

    @Override
    public ArticleLook insert(Long id, int number) {
        // 形参，前端接收，代表数量
        if (StringUtils.isEmpty(number)) {
            // 生成随机的文章访客
            Random random = new Random();
            int numberNotExists = random.nextInt(500) + 89;
            for (int i = 0; i < numberNotExists; i++) {
                BizArticleLook articleLook = new BizArticleLook();
                articleLook.setId(0L);
                articleLook.setArticleId(id);
                articleLook.setUserId(0L);
                articleLook.setUserIp(IpUtils.getRandomIp());
                articleLook.setLookTime(new Date());
                articleLook.setCreateTime(new Date());
                articleLook.setUpdateTime(new Date());
                Assert.notNull(articleLook, "ArticleLook不可为空！");
                bizArticleLookMapper.insertSelective(articleLook);
            }

        } else {
            for (int i = 0; i < number; i++) {
                BizArticleLook articleLook = new BizArticleLook();
                articleLook.setId(0L);
                articleLook.setArticleId(id);
                articleLook.setUserId(0L);
                articleLook.setUserIp(IpUtils.getRandomIp());
                articleLook.setLookTime(new Date());
                articleLook.setCreateTime(new Date());
                articleLook.setUpdateTime(new Date());
                Assert.notNull(articleLook, "ArticleLook不可为空！");
                bizArticleLookMapper.insertSelective(articleLook);
            }
        }

        return null;

    }

    @Override
    public List<Long> getRandomArticleIds() {
        return bizArticleMapper.getArticleIds();

    }
}
