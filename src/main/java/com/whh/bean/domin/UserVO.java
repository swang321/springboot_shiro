package com.whh.bean.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date: 2018/12/18 14:42
 * @Description:
 * @Author admin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

    private Integer userId;

    private String username;

    private Integer status;

}
