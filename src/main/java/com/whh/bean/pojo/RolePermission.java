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
public class RolePermission {
    private Integer id;

    private Integer roleId;

    private Integer permissionId;

}