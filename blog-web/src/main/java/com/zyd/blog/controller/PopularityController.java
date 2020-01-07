package com.zyd.blog.controller;

import com.zyd.blog.business.entity.ArticleLook;
import com.zyd.blog.business.service.PopularityService;
import com.zyd.blog.persistence.mapper.BizCommentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("honor")
@Slf4j
public class PopularityController {
    @Autowired
    private PopularityService popularityService;
    @Autowired
    BizCommentMapper bizCommentMapper;


    @RequestMapping("hello")
    public void hello() {


        // @Scheduled(cron = "0 0 0/8 1-31 * ?")
        // @Scheduled(cron = "0/10 * * * * ?")
        // 1 随机获取文章的id集合
        List<Long> randomArticleIds = popularityService.getRandomArticleIds();
        // 2 访客的数量
        List<Integer> viewNumbe = new ArrayList<>();
        Random random = new Random();
        while (true) {
            int total = random.nextInt(10) + 1;
            viewNumbe.add(total);
            if (viewNumbe.size() == 15) {
                break;
            }

        }
        // 3 插入访客记录
        for (int i = 0; i < randomArticleIds.size(); i++) {
            ArticleLook insert = popularityService.insert(randomArticleIds.get(i), viewNumbe.get(i));
            log.error("大骚猪！！！！！！！！！！！！！！！！！！！！");

        }


    }



    /**
     * 1 手动人气增加
     */

    @RequestMapping(value = "/popularity")
    public Object popularity(@RequestParam(value = "articleId") Long id, @RequestParam(value = "number", required = false, defaultValue = "null") Integer number) {
        popularityService.insert(id, number);
        return "success";
    }

    /**
     * 2 点赞，输入点赞的次数和文章的id就好
     */
    @RequestMapping("praise")
    public Object praise(@RequestParam(value = "number") Integer number, @RequestParam(value = "id") Long id) {
        for (Integer i = 0; i < number; i++) {
            bizCommentMapper.doSupport(id);


        }

        return "success";
    }

    /**
     * 3 评论
     */
    @RequestMapping("comment")
    public Object comment() {
        return "success";
    }

    @RequestMapping("leaveMessage")
    public Object leaveMessage() {
        return "success";
    }
}
