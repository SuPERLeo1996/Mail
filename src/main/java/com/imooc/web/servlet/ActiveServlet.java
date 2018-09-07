package com.imooc.web.servlet;

import com.imooc.domain.User;
import com.imooc.service.UserService;
import com.imooc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: Leo
 * @Date: 2018/9/7 09:24
 * @Description: 用户激活的Servlet
 */
public class ActiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //接受激活码
            String code = request.getParameter("code");

            //根据激活码查询用户
            UserService userService = new UserServiceImpl();
            User user = userService.findByCode(code);

            if (user !=null){
                //已经查询到，修改用户的状态
                user.setState(1);
                user.setCode(null);
                userService.update(user);
                request.setAttribute("msg","您已经激活成功，请去登录");

            }else {
                //根据激活码没有查询到用户
                request.setAttribute("msg","您的激活码有误，请重新激活");
            }
            request.getRequestDispatcher("/msg.jsp").forward(request,response);


        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }


    }
}
