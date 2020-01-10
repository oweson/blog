package com.zyd.blog.controller.third_party_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2020/1/10 22:46
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Yesterday implements Serializable {
    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;
}
