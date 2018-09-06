package com.imooc.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * @Auther: Leo
 * @Date: 2018/9/6 18:39
 * @Description:
 */
public class JDBCUtils {
    private static DataSource dataSource = new ComboPooledDataSource("mysql");
    public static DataSource getDataSource(){
        return dataSource;
    }

    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }
}
