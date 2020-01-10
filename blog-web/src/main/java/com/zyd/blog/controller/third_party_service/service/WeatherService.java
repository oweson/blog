package com.zyd.blog.controller.third_party_service.service;

import com.zyd.blog.controller.third_party_service.response.WeatherResponse;
import org.springframework.stereotype.Repository;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2020/1/10 22:51
 */
public interface WeatherService {
    /**
     *     * 1 根据城市id来查询天气数据
     *     *
     *     * @param cityId
     *     * @return
     *    
     */
    WeatherResponse getDataByCityId(String cityId);
    /**
     *     * 2 根据城市名称来查询天气数据
     *     *
     *     * @param cityName
     *     * @return
     *    
     */
    WeatherResponse getDataByCityName(String cityName);

}
