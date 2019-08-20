<%@page import="entity.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	修改页面<br>
	<%
		Emp emp = (Emp) session.getAttribute("updateEmp");
		
	%>
<form action="EmpServlet?actions=updateEmp" method="post">
		<table border="0">
			<tr>
				<td>name:</td>
				<td><input type="text" name="name" value="<%=emp.getName()%>"></td>
			</tr>
			<tr>
				<td>sex:</td>
				<td><input type="text" name="sex" ></td>
			</tr>
            <tr>
                <td>score:</td>
                <td><input type="text" name="score" >
            </tr>
			<%--<tr>--%>
				<%--<td>sex:</td>--%>
				<%--<td>--%>
					<%--<input type="radio" name="userSex" value="男"  <%=stu.getStuSex().equals("男")?"checked":"" %>>男--%>
					<%--<input type="radio" name="userSex" value="女"  <%=stu.getStuSex().equals("女")?"checked":""%>>女--%>
				<%--</td>--%>
			<%--</tr>--%>

			<tr>
				<td><input type="submit" value="提交"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>