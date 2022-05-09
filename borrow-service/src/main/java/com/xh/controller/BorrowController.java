package com.xh.controller;

import com.xh.entity.BorrowDetail;
import com.xh.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/borrow/{uid}")
    BorrowDetail getBorrowDetailByUid(@PathVariable("uid") int uid){
        return service.getBorrowDetailByUid(uid);
    }
}
