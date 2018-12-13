package com.whh.service.impl;

import com.whh.bean.pojo.Permission;
import com.whh.dao.PermissionMapper;
import com.whh.service.IPermisssionService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2018/12/13 15:24
 * @Description:
 */
@Service
public class PermisssionServiceImpl implements IPermisssionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> loadMenu() {
        String userId = (String) SecurityUtils.getSubject().getSession().getAttribute("userSessionId");
        Map<String, Object> map = new HashMap<>(2);
        map.put("userId", userId);
        map.put("resourceType", 0);
        List<Permission> permissionList=permissionMapper.loadMenu(map);
        return permissionList;
    }
}
