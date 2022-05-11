package com.xh.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @Auther: xh
 * @Date: 2022/5/11
 * @Description: com.xh.config
 * @Version: 1.0
 */

@Component  //需要注册为bean
public class MyGlobalFifter implements GlobalFilter, Ordered {
    //过个过滤器需要指定顺序 Ordered
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        log.info("custom global filter");
//        return chain.filter(exchange);
        //拦截没有携带指定参数的请求
        //获取ServerHttoRequest对象
        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        //所有请求参数
        System.out.println(serverHttpRequest.getQueryParams());
        //是否含有 demo 参数  且值为1
        List<String> demo = serverHttpRequest.getQueryParams().get("demo");
        if (demo != null && demo.contains("1")){
            //向下一级传递
            return chain.filter(exchange);
        }else {
            return exchange.getResponse().setComplete();
        }
    }

    @Override
    public int getOrder() {
        return 0;
        //order值越小优先级越高 配置文件写的单个路由过滤器还是全局..都会受到order影响
        //配置文件中 从上到下 1++    order值一样 全局优先执行
    }
}
