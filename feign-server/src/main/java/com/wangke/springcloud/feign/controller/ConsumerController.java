package com.wangke.springcloud.feign.controller;

import com.wangke.springcloud.feign.feign.HelloFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("consumer")
public class ConsumerController {
    @Autowired
    HelloFeign helloFeign;

    @RequestMapping("hello")
    @ResponseBody
    public Object heoolo(){
        return  helloFeign.hello();
    }
}
