package com.whh.bean.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author admin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;

    private String username;

    private String name;

    private String password;

    private Integer status;

}