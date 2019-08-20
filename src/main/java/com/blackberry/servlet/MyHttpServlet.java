package com.blackberry.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bberzhou@gmail.com
 * @date 7/25/19 21:01
 * Create By IntelliJ IDEA
 */
public class MyHttpServlet extends MyGenericServlet{
    /*
    针对于HTTP协议定义的一个Servlet基类
 */
    @Override
    public void service (ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        if (servletRequest instanceof HttpServletRequest){
            //  强转
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            if (servletResponse instanceof HttpServletResponse){
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                service (request,response);
            }
        }

    }

    public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        //  获取请求方式
        String method = request.getMethod ();

        //  根据请求方式再调用对应的处理方法。
        if ("Get".equalsIgnoreCase (method)){
            doGet(request,response);
        }else if("POST".equalsIgnoreCase (method)){
            doPost(request,response);
        }

    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException {

    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException {}
}

/*
    HttpServlet
        1。是一个servlet，继承自GenericServlet，针对HTTP协议定制的。
        在service()方法中直接把ServletRequest和ServletResponse 转为HttpServletRequest和HttpServletResponse
        并调用了重载的service(HttpServletRequest,HttpServletResponse)
        在service(HttpServletRequest,HttpServletResponse)获取了请求方式:request.getMethod(),根据请求方式又创建了
        doXXX()方法---（XXX为具体实现的请求方式，比如doGet,doPOst）

        实际开发中，直接继承HttpServlet,并根据请求方式复写doXXX()方法接口。
        好处就是：直接由针对性的覆盖doXXX()方法；直接使用HttpServletRequest和HttpServletResponse,不再需要强转。



 */
