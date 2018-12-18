package com.whh.dao;

import com.whh.bean.pojo.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    void batchUserRole(@Param("userId") Integer userId, @Param("roleIds") List<Integer> roleIds);

    void deleteURByUserId(@Param("userIds") Integer[] userIds);
}