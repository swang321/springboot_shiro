package com.whh.controller;

import com.whh.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author admin
 * @Date: 2018/12/12 10:48
 * @Description:
 */
@Slf4j
@Controller
public class LoginController {

    @Resource
    private ILoginService loginService;

    @RequestMapping({"/", "login",""})
    public String index() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, HttpServletRequest request) {
        boolean flag = loginService.login(username, password, request);
        if (flag) {
            return "redirect:usersPage";
        }
        return "login";
    }

    @RequestMapping(value = "/usersPage")
    public String usersPage() {
        return "user/users";
    }

    @RequestMapping("/403")
    public String forbidden() {
        return "403";
    }

}
