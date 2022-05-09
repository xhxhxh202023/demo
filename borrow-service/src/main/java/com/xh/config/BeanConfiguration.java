package com.xh.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        //注册bean loadbalanced 负载均衡
        return new RestTemplate();
    }
}
