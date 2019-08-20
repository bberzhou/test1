<%@page import="entity.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 style="text-align: center">所有用户</h3>
	<%
		List<Emp> list = (List<Emp>)session.getAttribute("listEmp");
	%>
	<table border="1" cellpadding="10" cellspacing="0" style="margin: 10px auto">
		<tr>

            <th>姓名</th>
			<th>性别</th>
            <th>分数</th>
            <th>修改</th>
            <th>删除</th>


        </tr>
		
		<% 
			if(list != null ){ 
			 for(int i=0;i<list.size();i++){
				Emp emp = list.get(i);
		%>
		<tr>
            <td><%=emp.getName()%></td>
            <td><%=emp.getSex()%></td>
            <td><%=emp.getScore()%></td>

            <td><a href="EmpServlet?actions=updateEmp&name=<%=emp.getName()%>" target="showData" style="text-decoration: none;color:dodgerblue">修改</a></td>

            <td><a href="EmpServlet?actions=delEmp&name=<%=emp.getName()%>" target="showData" style="text-decoration: none;color: red">删除</a></td>
		</tr>
			<%}
			}else{
				out.write("查无信息！！");
			}
			%>
		
	</table>
</body>
</html>