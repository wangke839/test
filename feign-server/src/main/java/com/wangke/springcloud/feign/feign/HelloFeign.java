package com.wangke.springcloud.feign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "shop-server",fallback = HelloFeignCallback.class)
public interface HelloFeign {
    @RequestMapping("shop/hello")
    @ResponseBody
    public Object hello();
}
