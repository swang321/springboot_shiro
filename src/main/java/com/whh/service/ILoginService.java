package com.whh.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date: 2018/12/11 17:33
 * @Description:
 */
public interface ILoginService {

    boolean login(String username, String password, HttpServletRequest request);

    void logout();

}
