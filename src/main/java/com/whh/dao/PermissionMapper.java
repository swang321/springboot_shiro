package com.whh.dao;

import com.whh.bean.pojo.Permission;

import java.util.List;
import java.util.Map;

public interface PermissionMapper {
    int deleteByPrimaryKey(String permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(String permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<Permission> selectBysroleid(String roleid);

    List<Permission> loadMenu(Map<String,Object> map);

    /**
     * 根据roles 查询所有权限
     */
    List<Permission> selectBysroleids(List<Integer> ids);
}