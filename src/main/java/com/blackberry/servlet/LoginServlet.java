package com.blackberry.servlet;

import javax.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author bberzhou@gmail.com
 * @date 7/25/19 09:29
 * Create By IntelliJ IDEA
 */
public class LoginServlet implements Servlet {
    @Override
    public void init (ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig () {
        return null;
    }

    //  service 方法主要用于应答请求
    @Override
    public void service (ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("请求来了。。。");
        servletRequest.setCharacterEncoding ("utf-8");

            /*
            ServletRequest：封装了请求信息，可以从中获取任何的请求信息
            ServletResponse 封装了响应信息，如果想给用户什么响应，可以使用该接口的方法实现
            这两个接口的实现都是服务器给予实现的，并在服务器调用service方法时传入

            */
            String forName = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8&useSSL=true\n";
            String user = "root";
            String psd = "123456";

            /*
                getParameter（）方法根据请求参数的名字 ，返回参数值，但是如果参数有多个值（如box），就只能返回第一个参数值
             */
            String username = servletRequest.getParameter ("user");

            //  getParameterValues()方法返回的是一个数组，如果前台有多选的情况就可以用这个方法来获取
//            servletRequest.getParameterValues ("")


        //   Enumeration<String> getParameterNames();返回参数对应的enumeration对象，类似于servletConfig（或者servletContext)的getInitParameterName()方法
//            servletRequest.getParameterNames ();


        //Map<String, String[]> getParameterMap(); 返回请求参数的键值对 key:参数名,value：参数值，String类型的数组
//        servletRequest.getParameterMap ();



        /*
            servletResponse：封装了响应信息，想要给用户什么信息就可以使用该接口的方法实现
            servletResponse.getWriter ();返回PrintWriter对象，调用该对象的print()方法，
            将print()重的参数直接打印到客户的浏览器上面。

            servletResponse.setContentType():设置响应的内容的类型，可以是text,word
          */


        /*
            void sendRedirect(string location):请求重定向，此方法为HttpServletResponse中定义。
            
         */

            String  password = servletRequest.getParameter ("password");
        try {
            Class.forName (forName);
            Connection conn = DriverManager.getConnection (url,user,psd);
            String sql = "insert into test(user,password) values (?,?)";
            PreparedStatement ps = conn.prepareStatement (sql);
            ps.setObject (1,username);
            ps.setObject (2,password);
            System.out.println("注册成功！");
            servletResponse.setContentType ("text/html");
            PrintWriter out = servletResponse.getWriter ();
            String message = "您已注册成功！";

            out.print ("<h1>"+message+"<h1>");
            ps.execute ();
            ps.close ();
            conn.close ();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace ();

        }


    }

    @Override
    public String getServletInfo () {
        return null;
    }

    @Override
    public void destroy () {

    }
}
