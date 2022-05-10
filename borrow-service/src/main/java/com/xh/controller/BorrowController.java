package com.xh.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xh.entity.BorrowDetail;
import com.xh.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * @Auther: xh
 * @Date: 2022/5/9
 * @Description: com.xh.controller
 * @Version: 1.0
 */
@RestController
public class BorrowController {
    @Autowired
    BorrowService service;

    @HystrixCommand(fallbackMethod = "wrongPlan")   //hystrix备选方案
    @RequestMapping("/borrow/{uid}")
    BorrowDetail getBorrowDetailByUid(@PathVariable("uid") int uid){
        return service.getBorrowDetailByUid(uid);
    }

    //hystrix 备选方案
    BorrowDetail wrongPlan(int uid){
        return new BorrowDetail(null, Collections.emptyList());
    }
}
