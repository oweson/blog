package com.zyd.blog.rabbit2020.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2020/3/14 15:55
 */
@Data
@Component
@ConfigurationProperties(prefix = "adconf.mysql")
public class MySQLConfig {
    private String host;
    private Integer port;
    private String username;
    private String password;
}
