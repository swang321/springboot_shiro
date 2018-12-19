package com.whh.controller;

import com.whh.base.common.ServerResponse;
import com.whh.base.controller.BaseController;
import com.whh.bean.domin.Menu;
import com.whh.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @Date: 2018/12/13 15:19
 * @Description:
 */
@RestController
@RequestMapping("/permission")
public class PermissionController extends BaseController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/loadMenu")
    public ServerResponse<Menu> loadMenu() {
        return permissionService.loadMenu();
    }

    @RequestMapping("loadMenuAll")
    public ServerResponse<Menu> loadMenuAll(){
        return permissionService.loadMenuAll();
    }


}
