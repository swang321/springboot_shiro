package com.whh.controller;

import com.whh.base.common.ServerResponse;
import com.whh.base.controller.BaseController;
import com.whh.bean.domin.PageParam;
import com.whh.bean.dto.AddRoleDTO;
import com.whh.bean.dto.UpdateRoleDTO;
import com.whh.bean.pojo.Role;
import com.whh.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author admin
 * @Date: 2018/12/18 10:30
 * @Description:
 */
@Slf4j
@Controller
public class RoleController extends BaseController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/rolePage")
    @RequiresPermissions("role:list")
    public String index() {
        return "system/role/role";
    }

    @RequestMapping("role/list")
    @RequiresPermissions("role:list")
    @ResponseBody
    public Map<String, Object> roleList(PageParam param, Role role) {
        return super.selectByPageNumSize(param, () -> this.roleService.findAllRole(role));
    }

    @RequestMapping("role/add")
    @RequiresPermissions("role:add")
    @ResponseBody
    public ServerResponse addRoles(AddRoleDTO addRoleDTO) {
        try {
            this.roleService.addRoles(addRoleDTO);
            return ServerResponse.createBySuccessMsg();
        } catch (Exception e) {
            log.error("删除角色失败", e);
            return ServerResponse.createByErrorMsg();
        }
    }

    @RequestMapping("role/update")
    @RequiresPermissions("role:update")
    @ResponseBody
    public ServerResponse updateRoles(UpdateRoleDTO updateRoleDTO) {
        try {
            this.roleService.updateRoles(updateRoleDTO);
            return ServerResponse.createBySuccessMsg();
        } catch (Exception e) {
            log.error("更新角色失败", e);
            return ServerResponse.createByErrorMsg();
        }
    }

    @RequestMapping("role/delete")
    @RequiresPermissions("role:delete")
    @ResponseBody
    public ServerResponse deleteRoles(Integer[] roleIds) {
        try {
            this.roleService.deleteRoles(roleIds);
            return ServerResponse.createBySuccessMsg("删除角色成功！");
        } catch (Exception e) {
            log.error("删除角色失败", e);
            return ServerResponse.createByErrorMsg("删除角色失败，请联系网站管理员！");
        }
    }


    @RequestMapping("role/checkRoleName")
    @ResponseBody
    public boolean checkRoleName(String roleName, String oldRoleName) {
        if (StringUtils.isNotBlank(oldRoleName) && roleName.equalsIgnoreCase(oldRoleName)) {
            return true;
        }
        Role result = this.roleService.findByName(roleName);
        return result == null;
    }

    @RequestMapping("role/getRole")
    @ResponseBody
    public ServerResponse getRole(Integer roleId) {
        try {
            Role role = this.roleService.findByRoleId(roleId);
            return ServerResponse.createBySuccessData(role);
        } catch (Exception e) {
            log.error("获取角色信息失败", e);
            return ServerResponse.createByErrorMsg("获取角色信息失败，请联系网站管理员！");
        }
    }
}
