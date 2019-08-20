<%@ page import="java.util.List" %>
<%@ page import="entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<meta content="text/html" charset="UTF-8"/>
<body>
<h2></h2>

<script>
    //  确认是否要删除
    var content =$(this).parent().find("td:eq(0)").text();
    console.log(content);
    $(function () {
        $(".delete").click(function () {
            var flag = confirm("确认要删除"+content+"的信息嘛？");
            return flag;
        })
    })
</script>

<form action="Query.do" method="post">
    <table>
        <tr>
            <td>studentName:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>studentSex:</td>
            <td><input type="text" name="sex"></td>
        </tr>
        <tr>
            <td>studentScore:</td>
            <td><input type="text" name="score"></td>
        </tr>
        <tr>
            <td><input type="submit" value="查询"></td>
            <td><a href="addNewStudent.jsp">添加</a></td>
        </tr>
    </table>
</form>


    <br>
    <br>

    <%
        List<Student> students = (List<Student>) request.getAttribute ("students");
        if (students != null && students.size ()>0){
    %>
    <br>
    <br>
    <table border="1" cellpadding="10" cellspacing="0" style="align-content: center;margin: 50px auto;">
        <tr>
            <th>name</th>
            <th>sex</th>
            <th>score</th>
            <th></th>
            <th></th>
        </tr>
        <%
            for (Student student:students) {
        %>
        <tr>
            <td><%= student.getName()%></td>
            <td><%= student.getSex()%></td>
            <td><%= student.getScore()%></td>

            <td><a href="Edit.do?name=<%=student.getName()%>">更新</a></td>
            <%--执行删除操作，若目标页面不需要读取当前读取当前请求的request属性，就可以使用重定向，显示删除后的student的list--%>
            <td><a href="Delete.do?name=<%=student.getName()%>" class="delete">删除</a></td>
        <%
                }
        %>
    </table>
    <%

        }
    %>

</body>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
</script>
<script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
</html>
