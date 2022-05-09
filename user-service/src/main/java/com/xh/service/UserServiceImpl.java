package com.xh.service;

import com.xh.entity.User;
import com.xh.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: xh
 * @Date: 2022/5/9
 * @Description: com.xh.service
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }
}
