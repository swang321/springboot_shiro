package com.whh.bean.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author admin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    private Integer id;

    private Integer userId;

    private Integer roleId;

}