package com.whh.controller;

import com.whh.base.common.ServerResponse;
import com.whh.base.controller.BaseController;
import com.whh.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author admin
 * @Date: 2018/12/18 10:30
 * @Description:
 */
@Controller
public class RoleController extends BaseController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("role/list")
    @ResponseBody
    public ServerResponse roleList() {
        return roleService.allRole();
    }

}
