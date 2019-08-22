<%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 8/21/19
  Time: 08:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cookie的路径问题</title>
</head>
<body>
<%
    //  读取一个name为cookiePath的cookie

    String cookieValue = null;
    Cookie[] cookies = request.getCookies ();
    if (cookies !=null && cookies.length>0){
        for (Cookie cookie:cookies) {
            if ("cookiePath".equals (cookie.getName ())){
                cookieValue = cookie.getValue ();
            }

        }
    }
    if (cookieValue != null){
        out.println (cookieValue);
    }else {
        out.println ("没有指定的cookie");
    }
%>

</body>
</html>
