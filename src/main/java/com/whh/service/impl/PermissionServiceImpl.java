package com.whh.service.impl;

import com.google.common.collect.Lists;
import com.whh.base.common.ServerResponse;
import com.whh.bean.domin.Menu;
import com.whh.bean.domin.MenuPermission;
import com.whh.bean.domin.PageParam;
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
import java.util.stream.Collectors;

/**
 * @author admin
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
        List<Permission> permissionList = permissionMapper.loadMenu(map);

        Menu menuParents = new Menu();
        List<Menu> list = new ArrayList<>();
        //先找出父节点
        //    0  表示 parentId
        for (Permission permission : permissionList) {
            if (permission.getParentId() == 0) {
                Menu menuChildren = new Menu();
                menuChildren.setPermissionId(permission.getPermissionId());
                menuChildren.setText(permission.getPermission());
                menuChildren.setUrl(permission.getUrl());
                list.add(menuChildren);
            }
        }
        menuParents.setChildren(list);
        for (Menu child : menuParents.getChildren()) {
            findChildren(child, permissionList);
        }

        return ServerResponse.createBySuccessData(menuParents);
    }

    @Override
    public ServerResponse<Menu> loadMenuAll() {
        List<Permission> permissions = permissionMapper.findAll();
        Map<Integer, List<Permission>> permissionMap = permissions.stream().collect(Collectors.groupingBy(Permission::getParentId));
        List<Permission> parent = permissionMap.get(0);
        Menu menuPermission = new Menu();
        List<Menu> parentMenu = new ArrayList<>();
        //装载父节点
        parent.forEach(t -> {
            Menu menu = assembleMenu(t);
            parentMenu.add(menu);
        });
        menuPermission.setChildren(parentMenu);
        permissionMap.remove(0);
        menuPermission.getChildren().forEach(k -> findChildrenPermission(k, permissionMap));
        return ServerResponse.createBySuccessData(menuPermission);
    }

    @Override
    public List<MenuPermission> findAll(Permission permission, PageParam pageParam) {
        List<Permission> permissionList = permissionMapper.findAll();
        return assembleMenuPermission(permissionList);
    }

    /**
     * List<Permission>  转    List<MenuPermission>
     */
    private List<MenuPermission> assembleMenuPermission(List<Permission> permissions) {
        List<MenuPermission> menuPermissions = Lists.newArrayList();

        permissions.forEach(t -> {
            MenuPermission menuPermission = new MenuPermission();
            menuPermission.setMenuId(t.getPermissionId());
            menuPermission.setMenuName(t.getPermission());
            menuPermission.setPerms(t.getPerms());
            menuPermission.setParentId(t.getParentId());
            menuPermission.setType(String.valueOf(t.getResourceType()));
            menuPermission.setUrl(t.getUrl());
            menuPermissions.add(menuPermission);
        });

        return menuPermissions;
    }


    /**
     * 递归寻找子节点
     */
    private Menu findChildren(Menu menu, List<Permission> permissionList) {
        for (Permission menuChildren : permissionList) {
            if (menuChildren.getParentId().equals(menu.getPermissionId())) {

                if (menu.getChildren() == null) {
                    menu.setChildren(new ArrayList<>());
                }
                Menu menu1 = new Menu();
                BeanUtils.copyProperties(menuChildren, menu1);
                menu1.setText(menuChildren.getPermission());
                menu.getChildren().add(findChildren(menu1, permissionList));
            }
        }
        return menu;
    }

    /**
     * 递归寻找子节点
     */
    private Menu findChildrenPermission(Menu menu, Map<Integer, List<Permission>> permissionMap) {
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

    /**
     * 组装Menu
     */
    private Menu assembleMenu(Permission permission) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(permission, menu);
        menu.setText(permission.getPermission());
        menu.setId(permission.getPermissionId());
        return menu;
    }
}
