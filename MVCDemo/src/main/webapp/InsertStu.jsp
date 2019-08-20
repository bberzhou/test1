<%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 7/29/19
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/InsertStudentServlet" method="post">
    username:<input type="text" name="username">
    sex:<input type="text" name="sex">
    score:<input type="text" name="score">
    <input type="submit" value="submit">
</form>
<a href="/ListAllStudent">List All Student</a>

</body>
</html>
