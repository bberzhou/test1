<%@ page import="java.util.List" %>
<%@ page import="entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 7/28/19
  Time: 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示学生信息</title>
</head>
<body>
<%--<%= request.getAttribute ("student") %>--%>
<%--<br>--%>
<%--<%--%>
    <%--//  强转--%>
    <%--List<String> names = (List)request.getAttribute ("student");--%>

    <%--// for循环遍历打印--%>
    <%--for (String name : names) {--%>
        <%--%>--%>
<%--<%= name %>--%>
<%--<br>--%>
<%--<%--%>
    <%--}--%>
<%--%>--%>

<%
    List<Student> stu = (List<Student>)request.getAttribute ("students");

%>
<div class="myTable" style="align-content: center">
    <h3 style="text-align: center">员工信息</h3>
    <table border="1" cellpadding="10" cellspacing="0" style="align-content: center;margin: 50px auto;">
        <tr>
            <th>name</th>
            <th>sex</th>
            <th>score</th>
            <th>Delete</th>
            <th><a href="InsertStu.jsp">add</a></th>
        </tr>
        <%
            for (Student student:stu){

        %>
        <tr>
            <td><%=student.getName () %></td>
            <td><%=student.getSex () %></td>
            <td><%=student.getScore()%></td>
            <%--//  删除的时候，Get请求发送一个请求到后台需要一个加上一个唯一的识别--%>
            <td><a href="DeleteStudent?name=<%= student.getName()%>" style="">Delete</a></td>
            <td><a href="">Update</a></td>
        </tr>
        <%
            }
        %>
    </table>


</div>



</body>
</html>
