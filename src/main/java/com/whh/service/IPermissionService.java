package com.whh.service;

import com.whh.base.common.ServerResponse;
import com.whh.bean.domin.Menu;

/**
 * @Date: 2018/12/13 15:24
 * @Description:
 */
public interface IPermissionService {
    ServerResponse<Menu> loadMenu();
}
