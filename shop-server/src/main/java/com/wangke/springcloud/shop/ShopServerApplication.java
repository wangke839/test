package com.wangke.springcloud.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.wangke.springcloud.mongo")
public class ShopServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopServerApplication.class,args);
    }
}
