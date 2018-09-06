package com.imooc.dao;

import com.imooc.domain.User;

import java.sql.SQLException;

/**
 * @Auther: Leo
 * @Date: 2018/9/6 18:42
 * @Description:
 */
public interface UserDao {
    void regist(User user) throws SQLException;
}
