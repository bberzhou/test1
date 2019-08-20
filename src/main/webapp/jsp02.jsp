<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 7/27/19
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP语法</title>

</head>
<body>
<%--
    1。JSP模版元素：JSP页面中的静态HTML内容称之为JSP模版元素

    2。JSP表达式：提供了将一个Java变量或表达式的计算结果输出到客户端的简化方式，
              它将要输出的变量或表达式直接封装在<%= %>之中
              注意：1）JSP表达式中的变量或表达式的计算结果被换成一个字符串，然后被插入进
                    整个JSP页面输出结果的相应位置处
                   2）JSP表达式中的变量或表达式后面不能有分号 ;，JSP表达式被翻译成Servlet程序中的一条out.print()语句


--%>
<%
    Date date = new Date ();
    out.println (date);
%>
<%--JSP 表达式，需要现有一个声明--%>
<%= date%>

3。<%--脚本片段--%>
<%
    String  ageStr = request.getParameter ("age");
    Integer  age = Integer.parseInt (ageStr);
    if (age>=18){
%>
    成人。。。。
<%
    }else {
%>
未成年人...
<%
    }
%>

    <%--
        4。JSP声明将Java代码封装在<%! %>之中，它里面的代码会被插入进servlet的jspService方法
            的外面，所以JSP声明可以用于定义JSP页面转换成的Servlet程序的静态页面代码快、成员变量和方法

    --%>
<%!
    void test(){};  // 定义一个方法，但是很少使用
%>
<%--
    JSP注释会阻止Java代码的执行

    html注释 <!-- -->
--%>



</body>
</html>
