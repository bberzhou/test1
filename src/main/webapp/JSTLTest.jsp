<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 8/1/19
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="javax.servlet.jsp.jstl" %>
<html>
<head>
    <title>JSTL 练习</title>

</head>
<body>
<%
    request.setAttribute ("req","request容器");

%>
<%--设置属性的格式--%>
<%--<c:set var="key" value="value" scope="page/request/session/application">--%><%--</c:set>--%>
<c:set var="kk" value="我是session" scope="session"></c:set>

<%--获取容器中的值--%>
${requestScope.req}<br>
${sessionScope.kk}


</body>
</html>
