package com.blackberry.test;



import javax.servlet.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author bberzhou@gmail.com
 * @date 7/23/19 07:03
 * Create By IntelliJ IDEA
 */
public class ServletTest implements Servlet{
    @Override
/*
    ServletConfig:封装了servlet的配置信息，


    获取Servlet的配置名称
    String getServletName();



    servlet上下文，可以由servletCong 来获取，
    该对象代表当前web应用：可以认为servletConfig是当前web应用的一个大管家，可以获取
    当前web应用的各个方面的信息。
    ServletContext getServletContext();



    获取指定参数名的初始化参数
    String getInitParameter(String var1);

    获取参数名组成的Enumeration组成的对象
    Enumeration<String> getInitParameterNames();
 */
    public void init (ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化");
        //  获取初始化参数
        String user= servletConfig.getInitParameter ("user");
        System.out.println (user);

        //获取servletContext对象
        ServletContext  servletContext = servletConfig.getServletContext ();
        //  获取当前web应用的某一个文件在服务器上的绝对路径
        String realpath = servletContext.getRealPath ("文件名");

        //  获取当前web应用的名称
        String path = servletContext.getContextPath ();
        //  获取当前web应用的某一个文件对应的输入流
        InputStream is = servletContext.getResourceAsStream ("");
    }

    @Override
    public ServletConfig getServletConfig () {
        return null;
    }

    @Override
    public void service (ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service");

    }

    @Override
    public String getServletInfo () {
        return null;
    }

    @Override
    public void destroy () {
        System.out.println("销毁");

    }

    public ServletTest() {
        System.out.println("constructor");
    }
}

