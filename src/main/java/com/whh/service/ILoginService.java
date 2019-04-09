package com.whh.service;

import com.whh.base.common.ServerResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date: 2018/12/11 17:33
 * @Description:
 */
public interface ILoginService {

    ServerResponse login(String username, String password, HttpServletRequest request);

    void logout();

}
