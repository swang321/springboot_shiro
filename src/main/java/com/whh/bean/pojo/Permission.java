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
public class Permission {
    private Integer permissionId;

    private String url;

    private String permission;

    private String perms;

    private Integer resourceType;

    private Integer parentid;

}