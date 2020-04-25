package com.wangke.springcloud.feign.controller;

import com.wangke.springcloud.feign.feign.HelloFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("consumer")
public class ConsumerController {
    @Autowired
    HelloFeign helloFeign;
    @Autowired
    private RestTemplate restTemplate;
    /**
     * 用feign做服务调用与负载均衡
     * @return
     */
    @RequestMapping("hello")
    @ResponseBody
    public Object heoolo(){
        return  "服务调用者feign："+helloFeign.hello();
    }

    /**
     * 用ribbon做服务调用与负载均衡
     * @return
     */
    @RequestMapping("hello2")
    @ResponseBody
    public Object hello(){
        String forObject = restTemplate.getForObject("http://shop-server/shop/hello", String.class);
        return  "服务调用者ribbon："+forObject;
    }
}
