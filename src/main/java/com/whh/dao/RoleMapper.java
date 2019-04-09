package com.whh.dao;

import com.whh.bean.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectByUserId(Integer userId);

    List<Role> allRole(Role role);

    Role findByName(String roleName);

    void deleteRoles(@Param("roleIds")Integer[] roleIds);
}