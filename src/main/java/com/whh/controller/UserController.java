package com.whh.controller;

import com.whh.base.controller.BaseController;
import com.whh.bean.domin.PageParam;
import com.whh.bean.pojo.User;
import com.whh.service.IUserService;
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

    @Autowired
    private IUserService userService;

    @RequestMapping("userPage")
    public String index(Model model) {
        User user = super.getCurrentUser();
        model.addAttribute("user", user);
        return "system/user/user";
    }

    @RequestMapping("/user/list")
    @ResponseBody
    public Map<String, Object> userList(User user,PageParam pageParam) {
        return super.selectByPageNumSize(pageParam, () -> this.userService.findAll(user,pageParam));
    }

}
