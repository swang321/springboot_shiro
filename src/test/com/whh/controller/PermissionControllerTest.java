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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @Date: 2018/12/14 11:14
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionControllerTest {

    @Autowired
    private PermissionMapper permissionMapper;

    @Transactional(rollbackFor = Exception.class)
    @Test
    public void t() {
        List<Permission> permissions = permissionMapper.findAll();
        Map<Integer, List<Permission>> permissionMap = permissions.stream().collect(Collectors.groupingBy(t -> t.getParentId()));
        System.out.println(permissionMap);
        List<Permission> parent = permissionMap.get(0);
        Menu menuPermission = new Menu();
        List<Menu> parentMenu = new ArrayList<>();
        parent.forEach(t -> {
            Menu menu = assembleMenu(t);
            parentMenu.add(menu);
        });
        menuPermission.setChildren(parentMenu);
        permissionMap.remove(0);
        menuPermission.getChildren().forEach(k -> {
            findChildrenPermission(k, permissionMap);
        });
        System.out.println(menuPermission);
    }

    public Menu findChildrenPermission(Menu menu, Map<Integer, List<Permission>> permissionMap) {
        permissionMap.forEach((k, v) -> {
            if (menu.getPermissionId().equals(k)) {
                if (menu.getChildren() == null) {
                    menu.setChildren(new ArrayList<>());
                }
                permissionMap.get(k).forEach(t -> {
                    Menu menu1 = assembleMenu(t);
                    menu.getChildren().add(findChildrenPermission(menu1, permissionMap));
                });
            }
        });
        return menu;
    }

    public Menu assembleMenu(Permission permission) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(permission, menu);
        menu.setText(permission.getPermission());
        return menu;
    }

}









