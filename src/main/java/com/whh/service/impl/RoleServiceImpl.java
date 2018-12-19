package com.whh.service.impl;

import com.whh.base.common.ServerResponse;
import com.whh.bean.dto.AddRoleDTO;
import com.whh.bean.pojo.Role;
import com.whh.dao.RoleMapper;
import com.whh.dao.RolePermissionMapper;
import com.whh.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author admin
 * @Date: 2018/12/18 10:33
 * @Description:
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<Role> findAllRole(Role role) {
        return roleMapper.allRole(role);
    }

    @Override
    public Role findByName(String roleName) {
        return roleMapper.findByName(roleName);
    }

    @Override
    public Role findByRoleId(Integer roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteRoles(Integer[] roleIds) {
        roleMapper.deleteRoles(roleIds);
        rolePermissionMapper.deleteRoles(roleIds);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addRoles(AddRoleDTO addRoleDTO) {
        Role role = new Role();
        role.setRoleName(addRoleDTO.getRoleName());
        role.setDescription(addRoleDTO.getDescription());
        roleMapper.insertSelective(role);
        rolePermissionMapper.batchRolePermission(role.getRoleId(),addRoleDTO.getMenuIds());

    }
}
