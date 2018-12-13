package com.whh.service;

import com.whh.bean.pojo.User;

/**
 * @Date: 2018/12/11 17:29
 * @Description:
 */
public interface IUserService {
    User findByUserName(String username);
}
