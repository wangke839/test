package com.wangke.springcloud.feign.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
public class HelloFeignCallback implements HelloFeign{
    @RequestMapping("hello")
    @ResponseBody
    public Object hello(){
        return "服务错误";
    }
}
