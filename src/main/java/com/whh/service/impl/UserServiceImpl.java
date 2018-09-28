package com.whh.service.impl;


import com.whh.base.common.ServerResponse;
import com.whh.base.common.enums.ResponseEnum;
import com.whh.bean.dto.LoginDTO;
import com.whh.bean.dto.RegisterDTO;
import com.whh.bean.pojo.User;
import com.whh.dao.UserMapper;
import com.whh.service.IUserService;
import com.whh.base.utils.MD5Util;
import com.whh.base.utils.UID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @ProjectName: swang
 * @Author: swang
 * @Date: 2018/9/4 15:23
 * @Description:
 */
@Slf4j
@Service("userService")
public class UserServiceImpl implements IUserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public ServerResponse login(LoginDTO loginDTO) {
        User user = validUserName(loginDTO.getUsername());
        if (user == null) {
            log.error("login() 用户名不一致 登陆失败");
            return ServerResponse.createByErrorMsg(ResponseEnum.LOGIN_ERROR);
        }
        boolean valid = exposeMd5Salt(loginDTO.getPassword(), user.getPassword());
        if (valid) {
            log.info("登陆成功" + user.getUsername());
            return ServerResponse.createByErrorMsg(ResponseEnum.LOGIN_SUCCESS);
        }
        log.error("login() 登陆失败");
        return ServerResponse.createByErrorMsg(ResponseEnum.LOGIN_ERROR);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServerResponse register(RegisterDTO registerDTO) {

        User users = validUserName(registerDTO.getUsername());
        if (users != null) {
            return ServerResponse.createBySuccessMsg(ResponseEnum.USERNAME_ERROR);
        }
        User user = new User();
        BeanUtils.copyProperties(registerDTO, user);
        String md5SaltPwd = md5Salt(registerDTO.getPassword());
        user.setId(UID.getUUID());
        user.setPassword(md5SaltPwd);

        int count = userMapper.insertSelective(user);
        if (count > 0) {
            return ServerResponse.createBySuccessMsg(ResponseEnum.REGISTER_SUCCESS);
        }
        log.error("register() 注册失败");
        return ServerResponse.createBySuccessMsg(ResponseEnum.REGISTER_ERROR);
    }

    /**
     * 根据 name 查询 User
     *
     * @param username username
     * @return User
     */
    private User validUserName(String username) {
        User user;
        user = userMapper.selectByName(username);
        return user;
    }


    /**
     * 密码 md5 加盐
     *
     * @param password password
     * @return String
     */
    private String md5Salt(String password) {
        String md5SaltPwd;
        //  MD5加盐  加密
        md5SaltPwd = MD5Util.generate(password);
        return md5SaltPwd;
    }


    /**
     * 密码 md5 加盐    解密验证
     *
     * @param password   password
     * @param md5SaltPwd md5SaltPwd
     * @return boolean
     */
    private boolean exposeMd5Salt(String password, String md5SaltPwd) {
        boolean valid;
        //  MD5加盐  解密验证
        valid = MD5Util.verify(password, md5SaltPwd);
        return valid;
    }

}
