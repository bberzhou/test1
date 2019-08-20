<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'reg.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <style type="text/css">
        .label{
            width: 20%
        }
        .controller{
            width: 80%
        }
    </style>
</head>

<body>
<h1>用户注册</h1>
<hr>
<form name="regForm" action="RegServlet" method="Post" >
    <table border="0" width="800" cellspacing="0" cellpadding="0">
        <tr>
            <td class="label">用户名：</td>
            <td class="controller"><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td class="label">密码：</td>
            <td class="controller"><input type="password" name="mypassword" ></td>

        </tr>
        <tr>
            <td class="label">确认密码：</td>
            <td class="controller"><input type="password" name="confirmPassword" ></td>

        </tr>
        <tr>
            <td class="label">电子邮箱：</td>
            <td class="controller"><input type="text" name="email" ></td>
        </tr>
        <tr>
            <td class="label">性别：</td>
            <td class="controller"><input type="radio" name="gender" checked="checked" value="Male">男<input type="radio" name="gender" value="Female">女</td>

        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="注册"/>&nbsp;&nbsp;
                <input type="reset" value="取消"/>&nbsp;&nbsp;
            </td>
        </tr>
    </table>
</form>
</body>
</html>