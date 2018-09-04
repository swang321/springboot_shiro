package com.whh.demo.service;

import com.whh.demo.common.ServerResponse;
import com.whh.demo.dto.LoginDTO;
import com.whh.demo.dto.RegisterDTO;

/**
 * @ProjectName: swang
 * @Author: swang
 * @Date: 2018/9/4 15:22
 * @Description:
 */
public interface IUserService {

    /**
     * 用户登陆验证
     *
     * @param loginDTO loginDTO
     * @return ServerResponse
     */
    ServerResponse login(LoginDTO loginDTO);

    /**
     * 用户注册
     *
     * @param registerDTO registerDTO
     * @return ServerResponse
     */
    ServerResponse register(RegisterDTO registerDTO);
}
