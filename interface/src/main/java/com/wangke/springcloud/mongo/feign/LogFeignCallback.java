package com.wangke.springcloud.mongo.feign;

import com.wangke.springcloud.mongo.model.Log;
import com.wangke.springcloud.shop.comm.ResultInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

@Component
public class LogFeignCallback implements LogFeign, Serializable {
    @RequestMapping("log/save")
    @ResponseBody
    public Object save(Log log) {
        return new ResultInfo().err("服务错误");
    }
}
