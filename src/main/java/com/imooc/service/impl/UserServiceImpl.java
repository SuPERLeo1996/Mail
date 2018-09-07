package com.imooc.service.impl;

import com.imooc.dao.UserDao;
import com.imooc.dao.impl.UserDaoImpl;
import com.imooc.domain.User;
import com.imooc.service.UserService;
import com.imooc.utils.MailUtils;

import java.sql.SQLException;

/**
 * @Auther: Leo
 * @Date: 2018/9/6 18:43
 * @Description:
 */
public class UserServiceImpl implements UserService {

    /**
     * 业务层用户注册
     * @param user
     * @throws Exception
     */
    public void regist(User user) throws Exception {
        //将数据存入到数据库
        UserDao userDao = new UserDaoImpl();
        userDao.regist(user);
        //发生激活邮件
        MailUtils.sendMail(user.getEmail(),user.getCode());
    }

    /**
     * 根据激活码查询用户
     * @param code
     * @throws Exception
     */
    public User findByCode(String code) throws Exception {
        UserDao userDao = new UserDaoImpl();
        return userDao.findByCode(code);
    }

    /**
     * 业务层修改用户
     * @param user
     * @throws Exception
     */
    public void update(User user) throws Exception {
        UserDao userDao = new UserDaoImpl();
        userDao.update(user);

    }
}
