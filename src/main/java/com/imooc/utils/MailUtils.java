package com.imooc.utils;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @Auther: Leo
 * @Date: 2018/9/7 08:58
 * @Description:
 */
public class MailUtils {
    /**
     * 发生邮件的方法
     * @param to 给谁发邮件
     * @param code 邮件的激活码
     */
    public static void sendMail(String to,String code) throws Exception {
        //1.创建连接对象，连接邮箱服务器
        Properties properties = new Properties();
        //properties.setProperty("host","value");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("service@store.com","111");
            }
        });

        //2.创建邮件对象
        Message message = new MimeMessage(session);

        //2.1设置发件人
        message.setFrom(new InternetAddress("service@store.com"));

        //2.2设置收件人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));

        //2.3 设置邮件主题
        message.setSubject("激活邮件");

        //2.4 设置邮件正文
        message.setContent("<h1>激活邮件:</h1><h3><a href='http://localhost:8080/ActiveServlet?code="+code+"'>http://localhost:8080/ActiveServlet?code="+code+"</a></h3>", "text/html;charset=UTF-8");

        //3 发送一封激活邮件邮件
        Transport.send(message);
    }
}
