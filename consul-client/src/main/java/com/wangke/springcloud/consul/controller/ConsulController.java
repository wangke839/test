package com.wangke.springcloud.consul.controller;

import com.wangke.springcloud.consul.config.ConsulConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//动态刷新配置
@RefreshScope
public class ConsulController {
    @Value("${config.info}")
    private String configInfo;
    @Autowired
    private ConsulConfigInfo consulConfigInfo;



    @RequestMapping("getConfig")
    @ResponseBody
    public Object getConfig(){
        return  configInfo;
    }

    @RequestMapping("getConfig2")
    @ResponseBody
    public Object getConfigInfo(){
        return  consulConfigInfo;
    }
}
