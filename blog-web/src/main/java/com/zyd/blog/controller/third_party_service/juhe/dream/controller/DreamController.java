package com.zyd.blog.controller.third_party_service.juhe.dream.controller;

import com.zyd.blog.controller.third_party_service.juhe.dream.service.DreamService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/dream")
public class DreamController {
    @Autowired
    private DreamService dreamService;
    // http://localhost:1949/dream/getDreamInfo?keyword=%E7%88%B1%E6%83%85

    @RequestMapping("/getDreamInfo")
    public JSONObject getDreamInfo(String keyword){
        return dreamService.getDreamInfo(keyword);
    }


}
