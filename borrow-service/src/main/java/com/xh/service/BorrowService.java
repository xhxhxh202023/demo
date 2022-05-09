package com.xh.service;

import com.xh.entity.BorrowDetail;

/**
 * @Auther: xh
 * @Date: 2022/5/9
 * @Description: com.xh.service
 * @Version: 1.0
 */
public interface BorrowService {
    BorrowDetail getBorrowDetailByUid(int uid);
}
