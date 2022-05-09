package com.xh.controller;

import com.xh.entity.Book;
import com.xh.service.BookService;
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
public class BookController {
    @Autowired
    BookService service;

    @RequestMapping("book/{bid}")
    public Book getBookById(@PathVariable("bid")Integer bid){
        return service.getBookById(bid);
    }
}
