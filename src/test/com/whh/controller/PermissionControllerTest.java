package com.whh.controller;

import com.whh.bean.pojo.Permission;
import com.whh.bean.pojo.Role;
import com.whh.bean.pojo.User;
import com.whh.dao.PermissionMapper;
import com.whh.dao.RoleMapper;
import com.whh.dao.UserMapper;
import com.whh.dao.UserRoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @Date: 2018/12/14 11:14
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionControllerTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Transactional(rollbackFor = Exception.class)
    @Test
    public void t() {
        List<Integer> roleIds = new ArrayList<>();
        roleIds.add(1);
        roleIds.add(2);
        userRoleMapper.batchUserRole(10,roleIds);

    }


}









