package com.blackberry.servlet;


import com.blackberry.entity.Users;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @author bberzhou@gmail.com
 * @date 7/24/19 14:20
 * Create By IntelliJ IDEA
 */
public class RegServlet extends HttpServlet {
    /*
        Servlet容器负责Servlet和客户的通信以及调用Servlet的方法，
        Servlet和客户的通信采用"请求/响应"的模式
        Servlet可以完成如下功能：
            1。创建并返回基于客户请求的动态html页面
            2。创建可嵌入到现有html页面中的部分html页面
            3。与其他服务器资源（数据库或者基于Java的应用程序）进行通信
     */

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding ("utf8");

        Users users = new Users ();
        String username,password,email,gender;
        try {
            username = request.getParameter ("username");
            password = request.getParameter ("password");
            email = request.getParameter ("email");
            gender = request.getParameter ("gender");
            users.setUsername (username);
            users.setPassword (password);
            users.setEmail (email);
            users.setGender (gender);
            System.out.println(users.getUsername ()+"   "+users.getEmail ());




        }catch (Exception e){
            e.printStackTrace ();
        }
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){

    }
}
