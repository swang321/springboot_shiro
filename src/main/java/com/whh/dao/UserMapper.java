package com.whh.dao;

import com.whh.bean.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    User findByUserName(String username);

    List<User> findAll(User user);

    void deleteUser(@Param("userIds") Integer [] userIds);

}