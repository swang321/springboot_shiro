package com.whh.controller;

import com.whh.bean.pojo.Permission;
import com.whh.service.IPermisssionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Date: 2018/12/13 15:19
 * @Description:
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermisssionService permisssionService;

    @RequestMapping("/loadMenu")
    public List<Permission> loadMenu(){
        return permisssionService.loadMenu();
    }


}
