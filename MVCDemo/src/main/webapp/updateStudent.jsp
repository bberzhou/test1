<%@ page import="entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 8/9/19
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新学生信息</title>
</head>
<meta charset="UTF-8">
<body>
<%
    Object msg = request.getAttribute ("message");
    if (msg != null) {
        out.println ("<br>");
        out.println ("" + msg + "");

    }
%>w
<%
    Student student = (Student) request.getAttribute ("stu");
%>
<form action="Update.do" method="post">
    <input type="hidden" name="oldName" value="<%=student.getName()%>">
    <table>
        <tr>
            <td>studentName:</td>
            <td><input type="text" name="name" value="<%=student.getName()%>"></td>
        </tr>
        <tr>
            <td>studentSex:</td>
            <td><input type="text" name="sex" value="<%=student.getSex()%>"></td>
        </tr>
        <tr>
            <td>studentScore:</td>
            <td><input type="text" name="score" value="<%=student.getScore()%>"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>

</body>
</html>
