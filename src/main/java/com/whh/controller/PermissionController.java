package com.whh.controller;

import com.whh.base.common.ServerResponse;
import com.whh.base.controller.BaseController;
import com.whh.bean.domin.Menu;
import com.whh.bean.domin.MenuPermission;
import com.whh.bean.domin.PageParam;
import com.whh.bean.pojo.Permission;
import com.whh.service.IPermissionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @Date: 2018/12/13 15:19
 * @Description:
 */
@Controller
public class PermissionController extends BaseController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/permission/loadMenu")
    @ResponseBody
    public ServerResponse<Menu> loadMenu() {
        return permissionService.loadMenu();
    }

    @RequestMapping("/permission/loadMenuAll")
    @ResponseBody
    public ServerResponse<Menu> loadMenuAll(){
        return permissionService.loadMenuAll();
    }

    @RequestMapping("/permissionPage")
    @RequiresPermissions("permission:list")
    public String index() {
        return "system/menu/menu";
    }

    @RequiresPermissions("permission:list")
    @RequestMapping("/permission/list")
    @ResponseBody
    public List<MenuPermission> userList(Permission permission, PageParam pageParam) {
        return this.permissionService.findAll(permission, pageParam);
    }

}
