package com.whh.bean.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date: 2018/12/20 14:01
 * @Description:
 * @Author admin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuPermission {

    private Integer menuId;

    private Integer parentId;

    private String menuName;

    private String url;

    private String perms;

    private String type;

}
