package com.whh.service;

import com.whh.base.common.ServerResponse;
import com.whh.bean.domin.Menu;
import com.whh.bean.domin.MenuPermission;
import com.whh.bean.domin.PageParam;
import com.whh.bean.pojo.Permission;

import java.util.List;

/**
 * @Date: 2018/12/13 15:24
 * @Description:
 */
public interface IPermissionService {
    ServerResponse<Menu> loadMenu();

    ServerResponse<Menu> loadMenuAll();

    List<MenuPermission> findAll(Permission permission, PageParam pageParam);
}
