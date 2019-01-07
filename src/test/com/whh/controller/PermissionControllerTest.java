package com.whh.controller;

import com.google.common.collect.Lists;
import com.whh.bean.pojo.RolePermission;
import com.whh.dao.RolePermissionMapper;
import org.apache.ibatis.annotations.Select;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @Date: 2018/12/14 11:14
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionControllerTest {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Transactional(rollbackFor = Exception.class)
    @Test
    public void t() {





        Integer roleId = 10;

        List<Integer> permsIds = Lists.newArrayList(10, 20, 4);

        List<RolePermission> permissions = rolePermissionMapper.findByRoleId(roleId);
        List<Integer> hadIds = permissions.stream().map(RolePermission::getPermissionId).collect(Collectors.toList());
        hadIds.forEach(System.out::println);


        List<Integer> delete = hadIds.stream().filter(item -> !permsIds.contains(item)).collect(Collectors.toList());
        delete.forEach(t -> System.out.println("delete" + t));

        List<Integer> insert = permsIds.stream().filter(item -> !hadIds.contains(item)).collect(Collectors.toList());
        insert.forEach(t -> System.out.println("insert" + t));
    }

}









