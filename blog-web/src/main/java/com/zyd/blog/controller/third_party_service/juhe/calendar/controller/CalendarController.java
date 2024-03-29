package com.zyd.blog.controller.third_party_service.juhe.calendar.controller;

import com.zyd.blog.controller.third_party_service.juhe.calendar.service.CalendarService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
    @Autowired
    private CalendarService calendarService;

    @RequestMapping("/{type}")
    public JSONObject calendar(@PathVariable String type){
        return calendarService.calendar(type);
    }


}
