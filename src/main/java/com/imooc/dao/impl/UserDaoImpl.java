package com.imooc.dao.impl;

import com.imooc.dao.UserDao;
import com.imooc.domain.User;
import com.imooc.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @Auther: Leo
 * @Date: 2018/9/6 18:43
 * @Description:
 */
public class UserDaoImpl implements UserDao {
    //DAO中保存用户的方法
    public void regist(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "insert into user values (?,?,?,?,?,?,?)";
        Object[] params = {user.getUid(),user.getUsername(),user.getPassword(),user.getNickname(),user.getEmail(),user.getState(),user.getCode()};
        queryRunner.update(sql,params);

    }

    public User findByCode(String code) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from user where code =?";
        User user = queryRunner.query(sql,new BeanHandler<User>(User.class),code);

        return user;
    }

    public void update(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "update user set username=?,password=?,nickname=?,email=?,state=?,code=? where uid = ?";
        Object[] params = {user.getUsername(),user.getPassword(),user.getNickname(),user.getEmail(),user.getState(),user.getCode(),user.getUid()};
        queryRunner.update(sql,params);
    }
}
