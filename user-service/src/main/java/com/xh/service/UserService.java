package com.xh.service;

import com.xh.entity.User;
import org.springframework.stereotype.Service;

/**
 * @Auther: xh
 * @Date: 2022/5/9
 * @Description: com.xh.service
 * @Version: 1.0
 */

public interface UserService {
    User getUserById(int id);
}
