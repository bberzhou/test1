package com.blackberry.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author bberzhou@gmail.com
 * @date 7/26/19 15:26
 * Create By IntelliJ IDEA
 */

public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
            服务器响应主要有两种，转发和重定向
            RequestDispatcher接口用forward实现请求转发
            1。调用HttpServletRequest的getRequestDispatcher()方法获取RequestDispatcher对象
                调用getRequestDispatcher()传入需要转发的地址
            2。调用HttpServletRequest 的forward(请求对象，响应对象) 进行请求的转发

            //        String path = "";
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher ("/"+path);
//        requestDispatcher.forward (req,resp);


            请求对象.getRequestDispatcher ("资源URL").forward (请求对象,响应对象);
            特点：
                1。转发属于服务器端跳转，只会发出一次请求
                2。响应之后地址栏不会发生改变
                    http://localhost:8080/ResponseServlet
                    请求之后不会改变
                3。在最终的Servlet中，request,对象和中转的那个request是同一个对象
                4。只能转发给当前web应用的资源
                5。/ 代表当前web应用的根目录

         */



        /*
            响应对象.sendRedirect ("资源URL"); url为重定向地址
            特点：
                1。转发属于客户端跳转，至少发出两次请求
                2。响应浏览器地址发生改变，地址栏是最后响应的那个地址

                3。重定向可以跳转外部地址
                    resp.sendRedirect("http://www.baidu.com")
                4。也可以跳转虚拟路径
                5。在最终的Servlet中，request对象中转的那个request不是同一个对象
                6。/ 代表的是当前web站点的根目录




         */
        //        req.getRequestDispatcher ("forwardPage.html").forward (req,resp);

        resp.sendRedirect ("forwardPage.html");

    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
