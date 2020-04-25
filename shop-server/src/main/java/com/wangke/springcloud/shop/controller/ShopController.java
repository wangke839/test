package com.wangke.springcloud.shop.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wangke.springcloud.mongo.feign.LogFeign;
import com.wangke.springcloud.mongo.model.Log;
import com.wangke.springcloud.shop.comm.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("shop")
public class ShopController {
    @Autowired
    LogFeign logFeign;
    @RequestMapping("hello")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "hystrixFallbackMethod")
    public Object hello(){
        Log log = new Log();
        log.setId(UUID.randomUUID().toString());
        log.setName("2222");
        log.setCreated(new Date());
        ResultInfo save = (ResultInfo) logFeign.save(log);
        if(save.getCode()==1002){
            return save.getResult();
        }
        System.err.println("调用了");
        return "shop-server:你好";
    }

    public String hystrixFallbackMethod(){
        return "调用失败";
    }

}
