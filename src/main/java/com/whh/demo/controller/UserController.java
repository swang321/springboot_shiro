package com.whh.demo.controller;

import com.whh.demo.common.ServerResponse;
import com.whh.demo.dto.LoginDTO;
import com.whh.demo.dto.RegisterDTO;
import com.whh.demo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: swang
 * @Author: swang
 * @Date: 2018/9/4 15:22
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/whh/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 用户登陆验证
     *
     * @param loginDTO loginDTO
     * @return ServerResponse
     */
    @PostMapping("/login")
    public ServerResponse login(@RequestBody LoginDTO loginDTO) {
        log.info("登陆验证" + "username:" + loginDTO.getUsername());
        return userService.login(loginDTO);
    }

    /**
     * 用户注册
     *
     * @param registerDTO registerDTO
     * @return ServerResponse
     */
    @PostMapping("/register")
    public ServerResponse register(@RequestBody RegisterDTO registerDTO) {
        return userService.register(registerDTO);
    }

}
