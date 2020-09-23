package com.gyh.usercenter.mapper.user;

import com.gyh.usercenter.domain.entity.user.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author cncoder
 */
@Repository
public interface UserMapper extends Mapper<User> {
}