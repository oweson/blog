package com.zyd.blog.controller.third_party_service.response;

import com.zyd.blog.controller.third_party_service.entity.Weather;
import lombok.Data;

import java.io.Serializable;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2020/1/10 22:47
 */
@Data
public class WeatherResponse implements Serializable {
    /**
     *     * 消息数据
     *    
     */
    private Weather data;
    /**
     *     * 消息状态
     *    
     */
    private String status;
    /**
     *     * 消息描述
     *    
     */
    private String desc;

}
