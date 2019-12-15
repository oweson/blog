package com.zyd.blog.controller;

import com.zyd.blog.business.service.PopularityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("honor")
public class PopularityController {
    @Autowired
    private PopularityService popularityService;
    @RequestMapping(value = "/popularity")
    public Object popularity(@RequestParam(value = "articleId") Long id,@RequestParam(value = "number",required = false,defaultValue = "null") Integer number){
        popularityService.insert(id,number);
        return "success";
    }
}
