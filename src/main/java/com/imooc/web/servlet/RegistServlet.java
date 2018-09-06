package com.imooc.web.servlet;

import com.imooc.domain.User;
import com.imooc.service.UserService;
import com.imooc.service.impl.UserServiceImpl;
import com.imooc.utils.UUIDUtils;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @Auther: Leo
 * @Date: 2018/9/6 18:45
 * @Description:
 */
public class RegistServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            //接受数据
            //处理中文乱码
            request.setCharacterEncoding("UTF-8");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String nickname = request.getParameter("nickname");
            String email = request.getParameter("email");

            //封装数据
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setNickname(nickname);
            user.setEmail(email);
            user.setState(0);//0:未激活 1::已经激活

            String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();
            user.setCode(code);
            //调用业务层数据
            UserService userService = new UserServiceImpl();

            userService.regist(user);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
