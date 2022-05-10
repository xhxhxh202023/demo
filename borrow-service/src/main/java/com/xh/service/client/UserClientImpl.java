package com.xh.service.client;

import com.xh.entity.User;
import org.springframework.stereotype.Component;

/**
 * @Auther: xh
 * @Date: 2022/5/10
 * @Description: com.xh.service.client
 * @Version: 1.0
 */
@Component
public class UserClientImpl implements UserClient {
    @Override
    public User getUserById(int uid) {
        //补救措施
        return new User();
    }
}
