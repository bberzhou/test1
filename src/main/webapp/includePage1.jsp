<%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 7/27/19
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试include指令</title>
</head>
<body>
<h3>include1</h3>
<%--
    include指令：通常用于通知JSP引擎在翻译当前JSP页面时将其他文件中的内容和并进当前JSP页面转换成的Servlet源文件中，
    这种在源文件级别进行引入的方式称为静态引入，语法<%@ include file = “relative URL”%> 里面是相对路径
    如果以"/"开头，表示相对于当前WEB应用程序的根目录（不是站点根目录），否则表示相对于当前文件
--%>
<%
    String  str="aaaa";
%>
<%@ include file="includePage2.jsp" %>


</body>
</html>
