<%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 7/27/19
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP 属性相关的方法</title>

</head>
<body>
<%--
    Object getAttribute(String name ):获取指定的属性
    Enumeration getAttributeNames():获取所有的属性的名字组成的Enumeration对象

    removeAttribute(String name):移除指定的属性
    void setAttribute(String name,Object value);//设置属性值，是键值对

    pageContext,request,session,application 对象都有这些方法,
    这四个对象也称为域对象;范围从小到大
    pageContext：属性的作用范围仅限于当前JSP页面
    request：属性的作用范围仅限于同一个请求
    session：属性的作用范围限于一次会话，：浏览器打开直到关闭称为一次会话(在此期间会话不失效)
    application：属性的作用范围限于当前web应用，是范围最大的属性作用范围，只要在一处设置属性之后，
                在其他各处的JSP和Servlet中都可以获取得到
--%>
<%
    pageContext.setAttribute ("pageContextAttr","pageContextValue");
    request.setAttribute ("requestAttr","requestValue");
    session.setAttribute ("sessionAttr","sessionValue");
    application.setAttribute ("applicationAttr","applicationValue");
%>
<br>
<br>
pageContextAttr:<%= pageContext.getAttribute("pageContextAttr")%>
<br>
<br>
requestAttr:<%= request.getAttribute("requestAttr")%>
<br>
<br>
sessionAttr:<%= session.getAttribute("sessionAttr")%>
<br>
<br>
applicationAttr:<%= application.getAttribute("applicationAttr")%>

<a href="jsp03Attribute_2.jsp"> To Att 2</a>

<%--
    pageContextAttr:pageContextValue

    requestAttr:requestValue

    sessionAttr:sessionValue

    applicationAttr:applicationValue
--%>

</body>
</html>
