package com.whh.service.impl;

import com.whh.base.common.ServerResponse;
import com.whh.bean.domin.Menu;
import com.whh.bean.pojo.Permission;
import com.whh.dao.PermissionMapper;
import com.whh.service.IPermissionService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2018/12/13 15:24
 * @Description:
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public ServerResponse<Menu> loadMenu() {
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userSessionId");
        Map<String, Object> map = new HashMap<>(2);
        map.put("userId", userId);
        map.put("resourceType", 0);
        List<Permission> permissionList=permissionMapper.loadMenu(map);

        Menu menuParens = new Menu();
        List<Menu> list = new ArrayList<>();
        //先找出父节点
        //    10  表示 parentId
        for (Permission permission : permissionList) {
            if (permission.getParentId()==0) {
                Menu menuChildren = new Menu();
                menuChildren.setPermissionId(permission.getPermissionId());
                menuChildren.setPermission(permission.getPermission());
                menuChildren.setUrl(permission.getUrl());
                list.add(menuChildren);
            }
        }
        menuParens.setChildren(list);
        for (Menu child : menuParens.getChildren()) {
            findChildren(child, permissionList);
        }

        return ServerResponse.createBySuccessData(menuParens);
    }


    /**
     * 递归寻找子节点
     */
    private Menu findChildren(Menu menu, List<Permission> permissionList) {
        for (Permission menuChildren : permissionList) {
            if (menuChildren.getParentId().equals(menu.getPermissionId())){

                if (menu.getChildren()==null){
                    menu.setChildren(new ArrayList<>());
                }
                Menu menu1 = new Menu();
                BeanUtils.copyProperties(menuChildren,menu1);
                menu.getChildren().add(findChildren(menu1,permissionList));
            }
        }
        return menu;
    }
}
