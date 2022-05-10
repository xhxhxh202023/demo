package com.xh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Auther: xh
 * @Date: 2022/5/10
 * @Description: com.xh
 * @Version: 1.0
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HysDasApplication {
    public static void main(String[] args) {
        SpringApplication.run(HysDasApplication.class,args);
    }
}
