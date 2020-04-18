package com.wangke.springcloud.shop.controller;

import com.wangke.springcloud.mongo.feign.LogFeign;
import com.wangke.springcloud.mongo.model.Log;
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
    public Object hello(){
        Log log = new Log();
        log.setId(UUID.randomUUID().toString());
        log.setName("keke");
        log.setCreated(new Date());
        logFeign.save(log);
        return "你好";
    }

}
