package com.zyd.blog.controller.third_party_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2020/1/10 22:45
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast implements Serializable {
    private String date;
    private String high;
    private String fengxiang;
    private String low;
    private String fengli;
    private String type;

}
