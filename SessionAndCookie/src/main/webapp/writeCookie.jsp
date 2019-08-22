<%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 8/21/19
  Time: 08:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>写入一个cookie：cokiePath</title>
</head>
<body>
<%
    Cookie cookie = new Cookie ("cookiePath","cookiePathValue");
    //  cookie的作用范围：可以作用当前目录和当前目录的子目录，但是不能作用于当前目录的上一级目录；
    //  可以通过setPath方法来设置cookie的作用范围，
    cookie.setPath (request.getContextPath ());
    response.addCookie (cookie);
%>
<a href="cookiePath.jsp">to read cookie</a>
</body>
</html>
