package com.zyd.blog.controller;

import com.zyd.blog.business.service.PopularityService;
import com.zyd.blog.persistence.mapper.BizCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("honor")
public class PopularityController {
    @Autowired
    private PopularityService popularityService;
    @Autowired
    BizCommentMapper bizCommentMapper;

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
