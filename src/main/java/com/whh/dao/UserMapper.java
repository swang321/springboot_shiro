package com.whh.dao;

import com.whh.bean.pojo.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findByUserName(String username);

    List<User> findAll(User user);
}