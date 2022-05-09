package com.xh.service;

import com.xh.entity.Book;
import org.springframework.stereotype.Service;

/**
 * @Auther: xh
 * @Date: 2022/5/9
 * @Description: com.xh.service
 * @Version: 1.0
 */

public interface BookService {
    Book getBookById(Integer id);
}
