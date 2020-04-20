package com.wangke.springcloud.consul.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

//配置类
@JsonIgnoreProperties("$$beanFactory")
@Configuration
@ConfigurationProperties(prefix = "config")
@Data
public class ConsulConfigInfo implements Serializable {
    private String name;
    private String info;
}