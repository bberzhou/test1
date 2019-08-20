<%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 8/9/19
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<meta charset="UTF-8">
<body>
<%
    Object msg = request.getAttribute ("message");
    if (msg != null) {
        out.println ("<br>");
        out.println ("" + msg + "");

    }
%>
<form action="Add.do" method="post">
    <table>
        <tr>
            <td>studentName:</td>
            <td><input type="text" name="name" value="<%= request.getParameter("name")==null?"":request.getParameter("name")%>"></td>
        </tr>
        <tr>
            <td>studentSex:</td>
            <td><input type="text" name="sex" value="<%= request.getParameter("sex")==null?"":request.getParameter("sex")%>"></td>
        </tr>
        <tr>
            <td>studentScore:</td>
            <td><input type="text" name="score" value="<%= request.getParameter("score")==null?"":request.getParameter("score")%>"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
