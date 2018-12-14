package com.whh.controller;

import com.whh.bean.domin.Menu;
import com.whh.bean.pojo.Permission;
import com.whh.dao.PermissionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Date: 2018/12/14 11:14
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionControllerTest {

    @Autowired
    private PermissionMapper permissionMapper;

    @Test
    public void t() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("userId", 1);
        map.put("resourceType", 0);
        List<Permission> permissionList = permissionMapper.loadMenu(map);

        Menu menuParens = new Menu();
        List<Menu> list = new ArrayList<>();
        for (Permission permission : permissionList) {
            if (permission.getParentid().equals("0")) {
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
        for (Menu child : menuParens.getChildren()) {
            System.out.println(child);
        }

    }

    public Menu findChildren(Menu menu, List<Permission> permissionList) {
        for (Permission menuChildren : permissionList) {
            if (menuChildren.getParentid().equals(menu.getPermissionId())){

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









