package com.gyh.usercenter.controller;

import com.gyh.usercenter.domain.entity.user.User;
import com.gyh.usercenter.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author cncoder
 * @date 2020-07-28 8:57
 */
@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/test")
    public List<User> getUser() {
        User user = User.builder()
                .createTime(new Date())
                .updateTime(new Date())
                .avatarUrl("XXX")
                .bonus(1)
                .build();
        userMapper.insertSelective(user);
        List<User> users = userMapper.selectAll();
        return users;
    }

    @GetMapping("/testGet")
    public User query(User user) {
        return userMapper.selectOne(user);
    }

    @PostMapping("/testPost")
    public User queryPost(@RequestBody User user) {
        return userMapper.selectOne(user);
    }
}