package com.whh.service.impl;

import com.whh.base.common.ServerResponse;
import com.whh.base.utils.MD5Util;
import com.whh.bean.domin.PageParam;
import com.whh.bean.domin.UserVO;
import com.whh.bean.dto.RegisterDTO;
import com.whh.bean.dto.UpdateDTO;
import com.whh.bean.pojo.User;
import com.whh.dao.UserMapper;
import com.whh.dao.UserRoleMapper;
import com.whh.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @Date: 2018/12/11 17:29
 * @Description:
 */
@Service
public class UserServiceImpl implements IUserService {

    private final String ON = "on";
    private final int ONE = 1;
    private final int ZERO = 0;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public List<UserVO> findAll(User user, PageParam pageParam) {
        List<User> users = userMapper.findAll(user);
        List<UserVO> userVOS = new ArrayList<>();
        users.forEach(item -> {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(item, userVO);
            userVOS.add(userVO);
        });
        return userVOS;
    }

    @Override
    public Boolean userCheckUserName(String username) {
        User user = userMapper.findByUserName(username);
        return user == null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ServerResponse regUser(RegisterDTO registerDTO) {
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(MD5Util.MD5(registerDTO.getPassword()));
        if (ON.equals(registerDTO.getStatus())) {
            user.setStatus(ONE);
        } else {
            user.setStatus(ZERO);
        }
        userMapper.insertSelective(user);
        userRoleMapper.batchUserRole(user.getUserId(), registerDTO.getRoles());
        return ServerResponse.createBySuccessMsg();
    }

    @Override
    public ServerResponse getUserById(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            return ServerResponse.createByErrorMsg("用户不存在");
        }
        return ServerResponse.createBySuccessData(user);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ServerResponse deleteUser(Integer[] userIds) {
        userMapper.deleteUser(userIds);
        userRoleMapper.deleteURByUserId(userIds);
        return ServerResponse.createBySuccessMsg();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ServerResponse userUpdate(UpdateDTO updateDTO) {
        User user = new User();
        BeanUtils.copyProperties(updateDTO, user);
        if (ON.equals(updateDTO.getStatus())) {
            user.setStatus(ONE);
        } else {
            user.setStatus(ZERO);
        }
        userMapper.updateByPrimaryKeySelective(user);
        return ServerResponse.createBySuccessMsg();
    }
}
