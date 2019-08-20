<%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 7/27/19
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@page import="" errorPage="" isErrorPage="" %>
<html>
<head>
    <title>JSP指令</title>
    <%--
        JSP指令是为JSP引擎而设计的，他们并不直接产生任何可见输出，
        而只是告诉引擎如何处理JSP页面中的其余部分。
        JSP指令的语法格式
        <%@ 指令 属性名="值" %> JSP2.0中定义了page ,include taglib三种指令
        并且属性名部分是大小写敏感的。


        page指令用于定义JSP页面的各种属性，无论page指令出现在JSP页面中的什么地方，它作用的都是整个JSP页面
        一般是放在整个JSP页面的起始位置。
        <%@page import="" %> 当前JSP页面需要导入哪些类，但是有些包不用导入，会自动导入
        session="false/true" page是否可以使用session ,默认是true
        errorPage="自定义错误页面"    // 如果JSP出错，可以跳转进自定义的错误页面，
                                        就可以在这个页面里面使用Exception来判断是什么错误，
                                        内部是一个转发的机制，不是重定向
        isErrorPage=""  设置当前页面是不是错误页面，最好直接能访问，
                        对于tomcat服务器而言，WEB-INF 下的文件不能通过浏览器直接输入来访问
                        但通过请求的转发是可以的 并且在响应error.jsp时使用的时请求转发的方式

                        在web.xml下面配置也可以

    <error-page>
        <!--指定错误的代码，404没有指定的资源，500内部错误-->
        <error-code>500</error-code>
        <!--指定响应页面的位置-->
        <location>/WEB-INF/errorPage.jsp</location>
    </error-page>
    <error-page>
        <!--指定异常的类型及响应的页面-->
        <exception-type>java.lang.ArithmeticException</exception-type>
        <location>/WEB-INF/errorPage.jsp</location>
    </error-page>



         contentType属性：指定当前JSP页面的响应类型，实际调用的是response.setContentType("text/html;charset=utf-8");
                        通常情况下，对于JSP而言其取值均为"text/html;charset=utf-8"
         pageEncoding：指定当前JSP页面的字符编码，通常情况下和contentType中的charset一致；

         isELIgnored:指定当前JSP页面是否可以使用EL表达式，通常取值为true;






    --%>
</head>
<body>

</body>
</html>
