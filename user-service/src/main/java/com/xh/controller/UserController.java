package com.xh.controller;

import com.xh.entity.User;
import com.xh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: xh
 * @Date: 2022/5/9
 * @Description: com.xh.controller
 * @Version: 1.0
 */
@RestController
public class UserController {

    @Resource
    UserService service;

    @RequestMapping("/user/{uid}")
    public User getUserById(@PathVariable("uid") int uid){
        return service.getUserById(uid);
    }
}
