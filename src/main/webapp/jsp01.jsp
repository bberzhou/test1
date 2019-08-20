<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 7/26/19
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp01</title>
</head>
<body>
<%--

    JSP = Java Server Page,放在除了WEB-INF及其子目录外的其他任何目录
    1。JSP 是一种简化Servlet编写的技术，它将Java和HTML代码混合在同一个文件中编写。
    只对网页中要动态更新的内容采用Java代码来编写，静态页面就采用普通的HTML编写。
    新建一个JSP在<% %>中即可编写Java代码;
    2。HttpJspBase 继承自HttpServlet
    3。JSP本质上就是一个Servlet，每个JSP页面在第一次被访问时，JSP引擎将它翻译成为一个
        Servlet源程序，接着再把这个Servlet源程序编译成Servlet的class文件，
        然后再由web容器（Servlet引擎）像调用普通的Servlet程序一样的方式来装载和解释执行
        这个由JSP页面翻译成的Servlet程序
    4。使用<% %>编写的代码可以用到Request , Response,pageContext,Session
        application,config,out,page这8个隐含对象（实际上还可以使用一个叫exception的隐含对象）

        三大容器：
            1。request容器：只对一次请求有效，即转发有效
            2。session容器：一次会话有效(session超时除外，)，转发和重定向都有效
            3。application容器：服务器不重启的话都有效
           存：容器对象.setAttribute(String key,Object value)
                    <k,value>的键值对
                request.setAttribute (String s,Object value);
            取：容器对象.getAttribute(String key)

        隐含对象就是没有声明就可以直接使用的对象，JSP一共有9个
        1）request:HttpSevletRequest的一个对象  ----常用，在有转发的情况下可以跨页面获取属性值
        2）response:HttpServletResponse的一个对象(在JSP中很少用)
        3) pageContext:页面的上下文，是PageContext的一个对象，可以从该对象中获取到
            其他8个隐含对象，也可以从中获取到当前页面的信息（自定义标签时可以使用它）
        4）session：代表浏览器和服务器的一次会话，是HttpSession的一个对象。 -----常用
        5）application:代表当前web应用，是servletContext对象，就能获取当前web应用的初始化参数         ---常用
        6）config:当前JSP对应的Servlet的servletConfig对象，若需要访问当前JSP配置的初始化参数，
            需要通过映射的地址才可以
             <!--JSP内置对象config获取初始化参数的时候，需要配置一下映射-->
            <servlet>
                <servlet-name>helloJSP</servlet-name>
                <jsp-file>/hello.jsp</jsp-file>
                <init-param>
                    <param-name>test</param-name>
                    <param-value>testValue</param-value>
                    </init-param>
             </servlet>
             <servlet-mapping>
                <servlet-name>helloJSP</servlet-name>
                <url-pattern>/helloJSP</url-pattern>
             </servlet-mapping>
         7)out：JspWriter对象，调用out.println（）方法，可以直接把字符串打印到浏览器上面   ---常用
         8）page：是指向当前JSP对应的Servlet对象的引用，但为Object类型，只能调用Object类的方法
         9）exception：在一定条件下才可以使用  声明了<% page isErrorPage="true>才可以使用,


    pageContext ,request,session,application()  对属性的作用域的范围从小到大
    out ,reponses,config ,page
    exception





--%>
<%
    System.out.println("hello world");
    Date date = new Date ();
    System.out.println(date);

    //  隐含对象，没有声明就可以直接使用
    String name = request.getParameter ("name");
    System.out.println(name);
    /*test1test1
        http://localhost:8080/jsp01.jsp?name=kk
        out:
            hello world
            Fri Jul 26 16:07:59 CST 2019
            kk
     */
//    Class cl = response.getClass ();
//    System.out.println(response instanceof HttpServletResponse);  // true
    //  内置session对象
    System.out.println(session.getId ());   //获取session ID

    //  application对象，可以获取初始化参数
    System.out.println (application.getInitParameter ("username")); //kk


%>



</body>
</html>
