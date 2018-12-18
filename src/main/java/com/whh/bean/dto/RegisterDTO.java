package com.whh.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: swang
 * @Author: swang
 * @Date: 2018/9/4 15:42
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

    private String username;

    private String password;

    private String roles;

    private String status;
}
