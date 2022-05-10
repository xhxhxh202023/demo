package com.xh.service.client;

import com.xh.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: xh
 * @Date: 2022/5/10
 * @Description: com.xh.service.client
 * @Version: 1.0
 */
//@FeignClient(value = "userservice") //声明为userservice服务的http请求客户端
@FeignClient(value = "userservice", fallback = UserClientImpl.class) //补救措施
public interface UserClient {
    //resttemplate 请求
    //restTemplate.getForObject("http://userservice/user/" + uid, User.class);

    //openfeign
    @RequestMapping("/user/{uid}")
    User getUserById(@PathVariable("uid") int uid);
}
