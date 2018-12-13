package com.whh.service;

import com.whh.bean.pojo.Permission;

import java.util.List;

/**
 * @Date: 2018/12/13 15:24
 * @Description:
 */
public interface IPermisssionService {
    List<Permission> loadMenu();
}
