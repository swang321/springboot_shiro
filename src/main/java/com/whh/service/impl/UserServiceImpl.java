package com.whh.service.impl;

import com.whh.base.common.ServerResponse;
import com.whh.bean.domin.PageParam;
import com.whh.bean.pojo.User;
import com.whh.dao.UserMapper;
import com.whh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date: 2018/12/11 17:29
 * @Description:
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public List<User> findAll(User user, PageParam pageParam) {
        return userMapper.findAll(user);
    }
}
