package com.zyd.blog.controller.third_party_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2020/1/10 22:43
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable {
    private String city;

    private String aqi;

    private String wendu;

    private String ganmao;

    private Yesterday yesterday;

    private List<Forecast> forecast;

}
