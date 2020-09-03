package com.gyh.usercenter.service.user.impl;

import com.gyh.usercenter.domain.entity.user.User;
import com.gyh.usercenter.mapper.user.UserMapper;
import com.gyh.usercenter.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
