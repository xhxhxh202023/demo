package com.xh.service;

import com.xh.entity.Book;
import com.xh.entity.Borrow;
import com.xh.entity.BorrowDetail;
import com.xh.entity.User;
import com.xh.mapper.BorrowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.temporal.Temporal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: xh
 * @Date: 2022/5/9
 * @Description: com.xh.service
 * @Version: 1.0
 */
@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    BorrowMapper mapper;

    @Override
    public BorrowDetail getBorrowDetailByUid(int uid) {
        List<Borrow> borrowList = mapper.getBorrowByUserId(uid);
        //restTemplate 远程调用
        RestTemplate restTemplate = new RestTemplate();
        //获取用户信息
        User user = restTemplate.getForObject("http://127.0.0.1:8301/user/" + uid, User.class);
        //获取每一本书详细信息
        List<Book> books = borrowList
                .stream()
                .map(b -> restTemplate.getForObject("http://127.0.0.1:8302/book/" + b.getBid(), Book.class))
                .collect(Collectors.toList());
        return new BorrowDetail(user, books);
    }
}
