package com.zyd.blog.controller.third_party_service;

import com.zyd.blog.controller.third_party_service.response.WeatherResponse;
import com.zyd.blog.controller.third_party_service.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2020/1/10 21:58
 */
@RestController
@RequestMapping("/weather")
public class whetherController {
    @Autowired
    private WeatherService weatherDataService;
    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getReportByCityId(@PathVariable("cityId") String cityId) {
        return weatherDataService.getDataByCityId(cityId);
    }
    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getReportByCityName(@PathVariable("cityName") String cityName) {
        return weatherDataService.getDataByCityName(cityName);
    }


}
