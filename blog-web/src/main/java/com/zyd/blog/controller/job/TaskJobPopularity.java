package com.zyd.blog.controller.job;

import cn.hutool.core.date.DateUtil;
import com.zyd.blog.business.entity.ArticleLook;
import com.zyd.blog.business.service.PopularityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * <p>
 * 定时任务
 * </p>
 *
 * @package: com.xkcoding.task.job
 * @description: 定时任务
 * @author: yangkai.shen
 * @date: Created in 2018/11/22 19:09
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Component
@Slf4j
public class TaskJobPopularity {

    @Autowired
    private PopularityService popularityService;

    @Scheduled(cron = "0 0 0/8 1-31 * ?")
    //@Scheduled(cron = "0/10 * * * * ?")
    public void getRandomArticleIds() {
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
    // 2 生成随机的数字

    // 3 插入操作

    // 4 取出所有的文章主键集合

    // 5 生成对应的几个

    /**
     * 1 按照标准时间来算，每隔 10s 执行一次
     */
//    @Scheduled(cron = "0/10 * * * * ?")
//    public void job1() {
//        log.info("【job1】开始执行：{}", DateUtil.formatDateTime(new Date()));
//        log.error("hahahahahahah");
//        log.debug("hei");
//    }

    /**
     * 从启动时间开始，间隔 2s 执行
     * 固定间隔时间
     */
//    @Scheduled(fixedRate = 2000)
//    public void job2() {
//        log.info("【job2】开始执行：{}", DateUtil.formatDateTime(new Date()));
//    }

    /**
     * 从启动时间开始，延迟 5s 后间隔 4s 执行
     * 固定等待时间
     */
//    @Scheduled(fixedDelay = 4000, initialDelay = 3600)
//    public void job3() {
//        log.info("【job3】开始执行：{}", DateUtil.formatDateTime(new Date()));
//    }
//
//    @Scheduled(cron = "0/5 * * * * ?")
//    public void demo2() {
//        System.out.println("皮皮虾来了");
//        log.error("大骚猪！！！！！！！！！！！！！！！！！！！！！！！");
//    }

//    @Scheduled(cron = "0  0/6 * * ?")
//    public void demo1() {
//        log.info("零点开始，每六个小时运行一次");
//        // 每天凌晨1点执行一次：0 0 1 * * ?
//
//    }
}
