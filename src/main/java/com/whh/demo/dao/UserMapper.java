package com.whh.demo.dao;

import com.whh.demo.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据 name 查询 User
     *
     * @param username username
     * @return User
     */
    User selectByName(String username);
}