package com.whh.dao;

import com.whh.bean.pojo.RolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);

    void deleteRoles(Integer[] roleIds);

    void batchRolePermission(@Param("roleId") Integer roleId,@Param("perms") List<Integer> perms);
}