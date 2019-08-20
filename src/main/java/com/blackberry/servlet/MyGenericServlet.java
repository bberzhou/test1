package com.blackberry.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author bberzhou@gmail.com
 * @date 7/25/19 15:08
 * Create By IntelliJ IDEA
 */
/*
    自定义的一个servlet接口实现类，让开发的servlet类都继承该类，以简化开发
 */
public abstract class MyGenericServlet implements Servlet,ServletConfig{
    //  以下方法是Servlet接口的方法
    @Override
    public void init (ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        init ();


    }

    // 因为上面的init函数已经被重写，在初始化时会报空指针异常这个初始化函数，不会出现空指针的异常。
    public void init()throws ServletException{ }

    @Override
    public ServletConfig getServletConfig () {
        return servletConfig;
    }

    @Override
    public abstract void service (ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException;


    @Override
    public String getServletInfo () {
        return null;
    }

    @Override
    public void destroy () {

    }
    //  自定义的一个Servlet变量
    private ServletConfig servletConfig;



    //  以下方法是ServletConfig接口里面的方法
    @Override
    public String getServletName () {
        return servletConfig.getServletName ();
    }

    @Override
    public ServletContext getServletContext () {
        return servletConfig.getServletContext ();
    }

    @Override
    public String getInitParameter (String s) {
        return servletConfig.getInitParameter (s);
    }

    @Override
    public Enumeration<String> getInitParameterNames () {
        return servletConfig.getInitParameterNames ();
    }
}
