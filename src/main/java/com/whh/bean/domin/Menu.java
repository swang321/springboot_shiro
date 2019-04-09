package com.whh.bean.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author admin
 * @Date: 2018/12/14 11:23
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    private Integer id;

    private Integer permissionId;

    private String url;

    private String text;

    private Integer parentId;

    private List<Menu> children;

}
