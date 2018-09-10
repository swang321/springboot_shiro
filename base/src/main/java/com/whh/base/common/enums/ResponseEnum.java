package com.whh.base.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ProjectName: swang
 * @Author: swang
 * @Date: 2018/9/4 15:59
 * @Description:
 */
@Getter
@AllArgsConstructor
public enum ResponseEnum {

    /**
     * 正确响应
     */
    SUCCESS(0, "SUCCESS"),

    /**
     * 错误响应
     */
    ERROR(1, "ERROR"),

    /**
     * 参数错误
     */
    PAEAM_ERROR(2, "参数错误"),

    /**
     * 注册成功
     */
    REGISTER_SUCCESS(3, "注册成功"),

    /**
     * 注册失败
     */
    REGISTER_ERROR(4, "注册失败"),

    /**
     * 用户名已存在
     */
    USERNAME_ERROR(5, "用户名已存在"),

    /**
     * 登录成功
     */
    LOGIN_SUCCESS(6, "登录成功"),

    /**
     * 登录失败
     */
    LOGIN_ERROR(7, "登录失败"),
    ;


    private Integer code;
    private String msg;

}
