package com.hvision.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.hvision.domain.User;
import com.hvision.service.IUserService;
import com.hvision.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dpeng
 * @create 2019-04-08 10:51
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     *  查询用户信息
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/getAllUser")
    public Map<String,Object> getAllUser(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer rows) {
        Page<User> userPage = userService.queryAllUser(new Page<>(page, rows));
        Map<String,Object> map = new HashMap<>();
        map.put("total",userPage.getTotal());
        map.put("rows",userPage.getRecords());
        return map;
    }

    /**
     *  添加用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "appendUser")
    public String appendUser(User user) {
        String msg;
        try {
            userService.appendUser(user);
            msg = "true";
        } catch (Exception e) {
            msg = "false";
        }
        return msg;
    }

    /**
     *  修改用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "modifyUser")
    public String modifyUser(User user) {
        String msg;
        try {
            userService.modifyUser(user);
            msg = "true";
        } catch (Exception e) {
            msg = "false";
        }
        return msg;
    }

    /**
     *  删除用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "removeUser")
    public String removeUser(User user) {
        String msg;
        try {
            userService.removeUser(user.getId());
            msg = "true";
        } catch (Exception e) {
            msg = "false";
        }
        return msg;
    }
}
