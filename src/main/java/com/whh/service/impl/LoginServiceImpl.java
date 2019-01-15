package com.whh.service.impl;

import com.whh.base.common.ServerResponse;
import com.whh.base.common.enums.ResponseEnum;
import com.whh.service.ILoginService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author admin
 * @Date: 2018/12/11 17:38
 * @Description:
 */
@Service
public class LoginServiceImpl implements ILoginService {
    @Override
    public ServerResponse login(String username, String password, HttpServletRequest request) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
          return ServerResponse.createByErrorMsg(ResponseEnum.LOGIN_ERROR);
        }

//        获取Subject实例对象
        Subject currentUser = SecurityUtils.getSubject();
        // 3、将用户名和密码封装到UsernamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 传到MyAuthorizingRealm类中的方法进行认证
        try {
            currentUser.login(token);
            return ServerResponse.createBySuccessMsg(ResponseEnum.SUCCESS);
        } catch (UnknownAccountException e) {
            token.clear();
            e.printStackTrace();
            return ServerResponse.createByErrorMsg(ResponseEnum.LOGIN_ERROR);

        } catch (IncorrectCredentialsException e) {
            token.clear();
            return ServerResponse.createByErrorMsg(ResponseEnum.LOGIN_ERROR);

        } catch (AuthenticationException e) {
            token.clear();
            e.printStackTrace();
            return ServerResponse.createByErrorMsg(ResponseEnum.LOGIN_ERROR);
        }
    }

    @Override
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}
