package com.hvision.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.hvision.domain.User;

public interface IUserService {

    Page<User> queryAllUser(Page<User> page);

    void appendUser(User user);

    void modifyUser(User user);

    void removeUser(Integer id);
}
