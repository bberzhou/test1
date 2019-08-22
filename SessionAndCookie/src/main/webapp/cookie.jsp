<%@ page import="java.text.CollationKey" %><%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 8/20/19
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试cookie</title>
</head>
<body>

<%
//    //  1。创建一个cookie对象,里面是一个键值对
//    Cookie cookie = new Cookie ("name","testCookie");
//    //  2。调用response的一个方法把cookie传给客户端
//    response.addCookie (cookie);

    //  3。获取cookie
    Cookie[] cookies = request.getCookies ();
    //  4。不为空就遍历数组
    if (cookies != null && cookies.length>0){
        for (Cookie cookie1:cookies) {
            //  5。获取cookie的name和value
            out.println (cookie1.getName ()+":"+cookie1.getValue ());

        }
    }else {
        //  如果没有cookie的话
        out.println ("没有cookie，正在创建并返回");

        Cookie cookie = new Cookie ("name","kk");
        //  setMaxAge设置Cookie的最大时效，以秒为单位，若为0：表示立即删除，若为负数：表示不存储该cookie，
        cookie.setMaxAge (30);
        response.addCookie (cookie);
    }
%>
</body>
</html>
