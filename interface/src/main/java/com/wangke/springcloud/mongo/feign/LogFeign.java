package com.wangke.springcloud.mongo.feign;

import com.wangke.springcloud.mongo.model.Log;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "log-server")
public interface LogFeign {
    @RequestMapping("/log/save")
    @ResponseBody
    public Object save(Log log);
}
