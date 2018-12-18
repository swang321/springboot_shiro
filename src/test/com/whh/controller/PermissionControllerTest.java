package com.whh.controller;

import com.whh.bean.domin.Menu;
import com.whh.bean.pojo.Permission;
import com.whh.bean.pojo.Role;
import com.whh.dao.PermissionMapper;
import com.whh.dao.RoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Test
    public void t() {
        //  根据userId  查询此用户具有多少种角色
        List<Role> roleList = roleMapper.selectByUserId("1");
        Set<String> roleSet =roleList.stream().map(Role::getRoleName).collect(Collectors.toSet());
        System.out.println(roleSet);

        List<String> ids =  roleList.stream().map(Role::getRoleId).collect(Collectors.toList());
        List<Permission> permissionList = permissionMapper.selectBysroleids(ids);
        System.out.println(permissionList);

    }


}









