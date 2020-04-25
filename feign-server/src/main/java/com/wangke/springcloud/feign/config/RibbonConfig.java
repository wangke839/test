package com.wangke.springcloud.feign.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class RibbonConfig {
    //RestTemplate实现负载均衡
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return  new RestTemplate();
    }
    //负载均衡策略
    @Bean
    public IRule iRule(){
        //随机
        //return  new RandomRule();
        //轮询
        return new RoundRobinRule();
        /** 如果一个服务挂了，会尝试几次访问，如果几次访问失败后，下次就跳过失败的服务。 **/
        //return new RetryRule();
        /** 当高并发时，会选中最空闲当服务 **/
        //return new BestAvailableRule();
        /** 按照权重访问 **/
        //return new WeightedResponseTimeRule();
        /** 先过滤清单再轮训 **/
        //return new PredicateBasedRule();

    }
}
