package com.wangke.springcloud.feign.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
public class HelloFeignCallback implements HelloFeign{
    @RequestMapping("shop/hello")
    @ResponseBody
    public String hello(){
        return "服务错误";
    }
}
