package com.whh.controller;

import com.whh.base.common.ServerResponse;
import com.whh.base.controller.BaseController;
import com.whh.bean.domin.PageParam;
import com.whh.bean.dto.RegisterDTO;
import com.whh.bean.dto.UpdateDTO;
import com.whh.bean.pojo.User;
import com.whh.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author admin
 * @Date: 2018/12/11 17:52
 * @Description:
 */
@Controller
public class UserController extends BaseController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequiresPermissions("user:list")
    @RequestMapping("userPage")
    public String index(Model model) {
        User user = super.getCurrentUser();
        model.addAttribute("user", user);
        return "system/user/user";
    }

    @RequiresPermissions("user:list")
    @RequestMapping("/user/list")
    @ResponseBody
    public Map<String, Object> userList(User user, PageParam pageParam) {
        return super.selectByPageNumSize(pageParam, () -> this.userService.findAll(user, pageParam));
    }

    @RequiresPermissions("user:add")
    @RequestMapping("/user/add")
    @ResponseBody
    public ServerResponse userAdd(RegisterDTO registerDTO) {
        return userService.regUser(registerDTO);
    }

    @RequiresPermissions("user:update")
    @RequestMapping("/user/update")
    @ResponseBody
    public ServerResponse userUpdate(UpdateDTO updateDTO) {
        return userService.userUpdate(updateDTO);
    }

    @RequiresPermissions("user:delete")
    @RequestMapping("/user/delete")
    @ResponseBody
    public ServerResponse deleteUser(Integer[] userIds) {
        return userService.deleteUser(userIds);
    }


    /**
     * 检查用户名是否重名
     */
    @RequestMapping("/user/checkUserName")
    @ResponseBody
    public Boolean userCheckUserName(String username) {
        return userService.userCheckUserName(username);
    }

    @RequestMapping("/user/getUser")
    @ResponseBody
    public ServerResponse getUserById(Integer userId) {
        return userService.getUserById(userId);
    }


}
