package com.whh.bean.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private String roleid;

    private String roleName;

    private String description;

//    /**
//     * 角色 -- 权限关系：多对多关系;
//     */
//    private List<Permission> permissions;
//
//    /**
//     *  一个角色对应多个用户
//     */
//    private List<User> users;

}