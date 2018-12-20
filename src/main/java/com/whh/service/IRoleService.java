package com.whh.service;

import com.whh.base.common.ServerResponse;
import com.whh.bean.dto.AddRoleDTO;
import com.whh.bean.dto.UpdateRoleDTO;
import com.whh.bean.pojo.Role;

import java.util.List;

/**
 * @author admin
 * @Date: 2018/12/18 10:33
 * @Description:
 */
public interface IRoleService {

    List<Role> findAllRole(Role role);

    Role findByName(String roleName);

    Role findByRoleId(Integer roleId);

    void deleteRoles(Integer[] roleIds);

    void addRoles(AddRoleDTO addRoleDTO);

    void updateRoles(UpdateRoleDTO updateRoleDTO);
}
