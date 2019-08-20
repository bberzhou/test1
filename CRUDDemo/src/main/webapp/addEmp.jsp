<%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 7/31/19
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工</title>
</head>
<body>
<form action="EmpServlet?actions=addEmp" method="post">
    empname:<input type="text" name="name">
    sex:<input type="text" name="sex">
    score:<input type="text" name="score">
    <input type="submit" value="submit">
</form>
</body>
</html>
