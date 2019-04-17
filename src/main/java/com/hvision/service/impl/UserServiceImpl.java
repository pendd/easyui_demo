package com.hvision.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.hvision.domain.User;
import com.hvision.mapper.UserMapper;
import com.hvision.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dpeng
 * @create 2019-04-08 10:50
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<User> queryAllUser(Page<User> page) {
        page.setRecords(userMapper.selectAllUser(page));
        return page;
    }

    @Override
    public void appendUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void modifyUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void removeUser(Integer id) {
        userMapper.deleteUserById(id);
    }
}
