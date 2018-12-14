package com.whh.bean.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Date: 2018/12/14 11:23
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    private String permissionId;

    private String url;

    private String permission;

    private String parentid;

    private List<Menu> children;

}
