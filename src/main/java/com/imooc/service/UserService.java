package com.imooc.service;

import com.imooc.domain.User;

import java.sql.SQLException;

/**
 * @Auther: Leo
 * @Date: 2018/9/6 18:43
 * @Description:
 */
public interface UserService {
    void regist(User user) throws SQLException;
}
