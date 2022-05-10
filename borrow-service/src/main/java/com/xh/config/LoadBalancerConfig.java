package com.xh.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * @Auther: xh
 * @Date: 2022/5/10
 * @Description: com.xh.config
 * @Version: 1.0
 */
public class LoadBalancerConfig {
    //将官方随机 注册为bean
    @Bean
    public ReactorLoadBalancer<ServiceInstance> RandomLoadBalancer(Environment environment, LoadBalancerClientFactory loadBalancerClientFactory){
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return  new RandomLoadBalancer(loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
    }
}
