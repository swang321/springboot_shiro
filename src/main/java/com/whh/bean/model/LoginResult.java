package com.whh.bean.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date: 2018/12/11 17:34
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResult {

    private boolean isLogin = false;
    private String result;

}
