package com.whh.service.impl;

import com.whh.base.common.ServerResponse;
import com.whh.base.utils.UID;
import com.whh.bean.domin.PageParam;
import com.whh.bean.dto.RegisterDTO;
import com.whh.bean.pojo.User;
import com.whh.dao.UserMapper;
import com.whh.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author admin
 * @Date: 2018/12/11 17:29
 * @Description:
 */
@Service
public class UserServiceImpl implements IUserService {

    private final String ON ="on";

    @Autowired
    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public List<User> findAll(User user, PageParam pageParam) {
        return userMapper.findAll(user);
    }

    @Override
    public Boolean userCheckUserName(String username) {
        User user = userMapper.findByUserName(username);
        return user == null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ServerResponse regUser(RegisterDTO registerDTO) {
        User user=new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(registerDTO.getPassword());
        if (ON.equals(registerDTO.getStatus())) {
            user.setStatus(1);
        }else {
            user.setStatus(0);
        }
        userMapper.insertSelective(user);
        String [] roles = registerDTO.getRoles().split(",");



        return ServerResponse.createBySuccessMsg();
    }
}
