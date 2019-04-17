package com.hvision.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.hvision.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    // 获取用户所有信息
    List<User> selectAllUser(Pagination page);

    // 添加用户信息
    void addUser(User user);

    // 修改用户信息
    void updateUser(User user);

    // 删除用户信息
    void deleteUserById(Integer id);
}
