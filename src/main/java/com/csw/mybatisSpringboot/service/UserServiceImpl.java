package com.csw.mybatisSpringboot.service;

import com.csw.mybatisSpringboot.entity.User;
import com.csw.mybatisSpringboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
    }
}
