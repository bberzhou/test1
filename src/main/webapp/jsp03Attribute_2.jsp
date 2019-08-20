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
    这四个对象也称为域对象
--%>
<%--<%--%>
    <%--pageContext.setAttribute ("pageContextAttr","pageContextValue");--%>
    <%--request.setAttribute ("requestAttr","requestValue");--%>
    <%--session.setAttribute ("sessionAttr","sessionValue");--%>
    <%--application.setAttribute ("applicationAttr","applicationValue");--%>
<%--%>--%>
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

<%--
    pageContextAttr:null

    requestAttr:null

    sessionAttr:sessionValue

    applicationAttr:applicationValue
--%>

</body>
</html>
