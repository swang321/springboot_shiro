package com.whh.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Date: 2018/12/19 11:41
 * @Description:
 * @Author admin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRoleDTO {

    private String roleName;

    private String description;

    private List<Integer> perms;

}
