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
public class Role {

    private Integer roleId;

    private String roleName;

    private String description;

}