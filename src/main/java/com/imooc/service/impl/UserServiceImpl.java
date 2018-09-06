package com.imooc.service.impl;

import com.imooc.dao.UserDao;
import com.imooc.dao.impl.UserDaoImpl;
import com.imooc.domain.User;
import com.imooc.service.UserService;

import java.sql.SQLException;

/**
 * @Auther: Leo
 * @Date: 2018/9/6 18:43
 * @Description:
 */
public class UserServiceImpl implements UserService {
    public void regist(User user) throws SQLException {
        //将数据存入到数据库
        UserDao userDao = new UserDaoImpl();
        userDao.regist(user);
        //发生激活邮件
    }
}
