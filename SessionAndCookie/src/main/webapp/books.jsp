<%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 8/20/19
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        a{
            text-decoration: none;
            font-size: 25px;
        }
    </style>
</head>
<body>
<%--
    显示最近浏览的5本书
    1。获取所有的Cookie
    2。从中筛选出Book的cookie
    如果cookieName=myBooks开头就是符合条件的
    3。显示cookieValue
--%>
<h4>Book Page</h4>
<a href="book.jsp?book=Javaweb">Javaweb</a><br><br>
<a href="book.jsp?book=Java">Java</a><br><br>
<a href="book.jsp?book=JavaScript">JavaScript</a><br><br>
<a href="book.jsp?book=Ajax">Ajax</a><br><br>
<a href="book.jsp?book=Spring">Spring</a><br><br>
<a href="book.jsp?book=SpringMVC">SpringMVC</a><br><br>
<a href="book.jsp?book=MaBatis">MaBatis</a><br><br>
<a href="book.jsp?book=Mysql">Mysql</a><br><br>
<a href="book.jsp?book=hibernate">hibernate</a><br><br>

<%
    Cookie [] cookies = request.getCookies ();

    if (cookies != null && cookies.length>0){
        for (Cookie cookie : cookies) {
            String cookieName = cookie.getName ();
            if (cookieName.startsWith ("myBooks")){
                out.println (cookie.getValue ());
                out.println ("<br>");
            }

        }
    }

%>
</body>
</html>
