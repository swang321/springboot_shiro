package com.whh.service;

import com.whh.base.common.ServerResponse;
import com.whh.bean.domin.PageParam;
import com.whh.bean.pojo.User;

import java.util.List;

/**
 * @Date: 2018/12/11 17:29
 * @Description:
 */
public interface IUserService {
    User findByUserName(String username);

    List<User> findAll(User user, PageParam pageParam);
}
