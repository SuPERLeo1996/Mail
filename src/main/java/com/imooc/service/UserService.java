package com.imooc.service;

import com.imooc.domain.User;

import java.sql.SQLException;

/**
 * @Auther: Leo
 * @Date: 2018/9/6 18:43
 * @Description:
 */
public interface UserService {
    void regist(User user) throws Exception;

    User findByCode(String code) throws Exception;

    void update(User user) throws Exception;
}
