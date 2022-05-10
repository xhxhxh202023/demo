package com.xh.service;

import com.xh.entity.Book;
import com.xh.entity.Borrow;
import com.xh.entity.BorrowDetail;
import com.xh.entity.User;
import com.xh.entity.mapper.BorrowMapper;
import com.xh.service.client.BookClient;
import com.xh.service.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//    @Resource
//    RestTemplate restTemplate;

    @Autowired
    UserClient userClient;
    @Autowired
    BookClient bookClient;

    @Override
    public BorrowDetail getBorrowDetailByUid(int uid) {
        List<Borrow> borrowList = mapper.getBorrowByUserId(uid);

        //  eureka注册后 直接写服务名称即可
//        User user = restTemplate.getForObject("http://userservice/user/" + uid, User.class);
        //openfeign
        User user = userClient.getUserById(uid);
        List<Book> books = borrowList
                .stream()
//                .map(b -> restTemplate.getForObject("http://bookservice:8302/book/" + b.getBid(), Book.class))
                //openfeign
                .map(b -> bookClient.getBookById(b.getBid()))
                .collect(Collectors.toList());
        return new BorrowDetail(user, books);
    }
}
