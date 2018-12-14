package com.whh.bean.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userId;

    private String username;

    private String name;

    private String password;

    private String status;

    /**
     *   一个用户具有多个角色
     */
//    private List<Role> roleList;
}