package com.blackberry.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bberzhou@gmail.com
 * @date 7/26/19 16:36
 * Create By IntelliJ IDEA
 */
public class rongqiServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  对象.setAttribute (key,"value");向容器中添加
        req.setAttribute ("key","我是request容器");
        //  转发
        req.getRequestDispatcher ("rongqi.jsp").forward (req,resp);
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost (req, resp);
    }
}
