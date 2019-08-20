<%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 7/27/19
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
</head>
<body>
<h3>我是jsp:include2</h3>
<%--<%= str%>--%>
<%= request.getParameter ("username")   //输出username = jspInclude1中的abcd
%>
</body>
</html>
