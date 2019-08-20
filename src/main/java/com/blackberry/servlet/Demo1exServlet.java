package com.blackberry.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author bberzhou@gmail.com
 * @date 7/25/19 14:14
 * Create By IntelliJ IDEA
 */
public class Demo1exServlet extends MyGenericServlet {
//    private ServletConfig servletConfig;
//    @Override
//    public void init (ServletConfig servletConfig) throws ServletException {
////        ServletContext servletContext = servletConfig.getServletContext ();
////        String initUsername = servletConfig.getInitParameter ("username");
////        String initPassword = servletConfig.getInitParameter ("password");
//        //  通过this把初始化时传递的对象，把他传给当前servlet的一个成员变量
//        this.servletConfig = servletConfig;
//
//
//    }
    @Override
    public void init(){
        System.out.println("初始化");
    }

//    @Override
//    public ServletConfig getServletConfig () {
//        return null;
//    }

    @Override
    public void service (ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //1  获取请求参数：username password
        String formUsername = servletRequest.getParameter ("username");
        String formPassword = servletRequest.getParameter ("password");

        // 2获取当前web应用的初始化参数:username,password ,需要使用ServletContext对象
//        ServletContext servletContext = servletRequest.getServletContext ();
//        String initUsername = servletContext.getInitParameter ("username");
//        String initPassword = servletContext.getInitParameter ("password");

        //  在继承MyGenericServlet类之后，就可以直接使用getServletContext()方法返回一个
        //  servletConfig.getServletContext ()对象，再调用getInitParameter等方法获取初始化参数
//        ServletContext servletContext = getServletConfig ().getServletContext ();
//        String initUsername = servletContext.getInitParameter ("username");
//        String initPassword = servletContext.getInitParameter ("password");

        String initUsername = getServletContext ().getInitParameter ("username");
        String initPassword = getServletContext ().getInitParameter ("password");

        System.out.println(formUsername);
        System.out.println(formPassword);

        //3.比对是否一致。

        //4。打印响应字符串
        PrintWriter printWriter = servletResponse.getWriter ();
        if (initUsername.equals (formUsername) && initPassword.equals (formPassword)){
            printWriter.print ("hello"+formUsername);
        }else {
            printWriter.print ("sorry"+formUsername);
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


/*
    GenericServlet
        1。是一个Servlet是Servlet接口和ServletConfig接口的实现类，但是是一个抽象类，
        其中service方法为抽象方法
        2。如果新建的servlet程序直接继承GenericServlet会使开发更简洁
    具体实现细节：
        1。在GenericServlet中声明了一个servletConfig类型的成员变量，在init(ServletConfig servletconfig)中对其初始化
        @Override
        public void init (ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        }
        2。利用servletConfig成员变量的方法实现了ServletConfig接口的方法
        3。还定义了一个init()方法，在init(ServletConfig )方法中对其调用，子类可以直接覆盖init()方法，在其中实现对Servlet的初始化
        4。**不要直接覆盖init(ServletConfig )，因为如果忘记编写super.init(config),而且后面还调用了ServletConfig接口里面的方法吗，
            就会出现空指针异常
        5。新建的init()方法，不是servlet的声明周期方法，而init(ServletConfig servletconfig) 是声明周期方法





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
    //  自定义的一个Servlet成员变量
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


 */