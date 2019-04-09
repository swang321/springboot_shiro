package com.whh.service.impl;

import com.whh.bean.dto.AddRoleDTO;
import com.whh.bean.dto.UpdateRoleDTO;
import com.whh.bean.pojo.Role;
import com.whh.bean.pojo.RolePermission;
import com.whh.dao.RoleMapper;
import com.whh.dao.RolePermissionMapper;
import com.whh.dao.UserRoleMapper;
import com.whh.service.IRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author admin
 * @Date: 2018/12/18 10:33
 * @Description:
 */
@Service
public class RoleServiceImpl implements IRoleService {
    private final RoleMapper roleMapper;

    private final RolePermissionMapper rolePermissionMapper;

    private final UserRoleMapper userRoleMapper;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper, RolePermissionMapper rolePermissionMapper, UserRoleMapper userRoleMapper) {
        this.roleMapper = roleMapper;
        this.rolePermissionMapper = rolePermissionMapper;
        this.userRoleMapper = userRoleMapper;
    }

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
        //删除角色
        roleMapper.deleteRoles(roleIds);
        //删除 角色所对应的权限
        rolePermissionMapper.deleteRoles(roleIds);
        //删除 角色所对应的用户
        userRoleMapper.deleteURByRoleId(roleIds);


    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addRoles(AddRoleDTO addRoleDTO) {
        Role role = assembleRole(addRoleDTO);
        roleMapper.insertSelective(role);
        rolePermissionMapper.batchRolePermission(role.getRoleId(), addRoleDTO.getPerms());

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateRoles(UpdateRoleDTO updateRoleDTO) {
        Role role = new Role();
        BeanUtils.copyProperties(updateRoleDTO, role);
        roleMapper.updateByPrimaryKeySelective(role);

        // 取出角色拥有的所有权限id
        List<RolePermission> permissions = rolePermissionMapper.findByRoleId(role.getRoleId());
        List<Integer> hadIds = permissions.stream().map(RolePermission::getPermissionId).collect(Collectors.toList());
        List<Integer> permsIds = updateRoleDTO.getPerms();

        // 前端传来的权限id 求差集  需要添加的
        List<Integer> insertIds = permsIds.stream().filter(item -> !hadIds.contains(item)).collect(Collectors.toList());
        insertIds.forEach(t -> System.out.println("insert" + t));
        batchInsert(role.getRoleId(), insertIds);
        // 前端传来的权限id 求差集  需要删除的
        List<Integer> deleteIds = hadIds.stream().filter(item -> !permsIds.contains(item)).collect(Collectors.toList());
        deleteIds.forEach(t -> System.out.println("delete" + t));
        batchDelete(role.getRoleId(), deleteIds);
    }

    /**
     * 批量插入
     */
    private void batchInsert(Integer roleId, List<Integer> insertIds) {
        if (!insertIds.isEmpty()) {
            rolePermissionMapper.batchRolePermission(roleId, insertIds);
        }
    }

    /**
     * 批量删除
     */
    private void batchDelete(Integer roleId, List<Integer> deleteIds) {
        if (!deleteIds.isEmpty()) {
            rolePermissionMapper.batchDeleteRolePermission(roleId, deleteIds);
        }
    }

    private Role assembleRole(AddRoleDTO addRoleDTO) {
        Role role = new Role();
        role.setRoleName(addRoleDTO.getRoleName());
        role.setDescription(addRoleDTO.getDescription());
        return role;
    }
}
