package com.whh.service;

import com.whh.base.common.ServerResponse;
import com.whh.bean.domin.PageParam;
import com.whh.bean.domin.UserVO;
import com.whh.bean.dto.RegisterDTO;
import com.whh.bean.dto.UpdateDTO;
import com.whh.bean.pojo.User;

import java.util.List;

/**
 * @Date: 2018/12/11 17:29
 * @Description:
 */
public interface IUserService {
    User findByUserName(String username);

    List<UserVO> findAll(User user, PageParam pageParam);

    Boolean userCheckUserName(String username);

    ServerResponse regUser(RegisterDTO registerDTO);

    ServerResponse getUserById(Integer userId);

    ServerResponse deleteUser(Integer[] userIds);

    ServerResponse userUpdate(UpdateDTO updateDTO);
}
