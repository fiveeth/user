package com.gyh.usercenter.service.user;

import com.gyh.usercenter.domain.entity.user.User;

/**
 * @author cncoder
 * @date 2020-07-28 9:40
 */
public interface UserService {
    /**
     * 根据id获取用户信息
     *
     * @param id
     * @return
     */
    User findById(Integer id);
}
