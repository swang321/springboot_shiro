package com.whh.service.impl;

import com.whh.base.common.ServerResponse;
import com.whh.bean.pojo.Role;
import com.whh.dao.RoleMapper;
import com.whh.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 * @Date: 2018/12/18 10:33
 * @Description:
 */
@Service
public class IRoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public ServerResponse allRole() {
        List<Role> roles = roleMapper.allRole();
        return ServerResponse.createBySuccessData(roles);
    }
}
