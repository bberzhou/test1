<%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 7/27/19
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试JSP标签引入</title>
</head>
<body>
<h3>okkkkk</h3
<%--
    JSP还提供了一种称之为action的元素，在JSP页面中使用action元素可以完成各种通用的JSP页面功能，
    也可以实现一些处理复杂业务逻辑的专用功能，action 元素采用XML元素的语法格式，即每个action元素子啊JSP
    页面中都以XML标签的形式出现，JSP中规范了一些标准的action元素，这些元素的标签名称以jsp作为前缀
    并且全部采用小写，例如<jsp:include>
    <jsp:include>标签用于把另外一个资源的输出内容插入进当前JSP页面的输出内容之中
    这种在JSP页面执行时的引入方式称之为动态引入。
    语法格式<jsp:include page="relative URL |<%= expression%%> flush="true/false"/>
    动态引入并不是像include指令那样生成一个Servlet源文件，而是生成两个Servlet源文件，然后通过一个方法的方式
    把目标页面包含进来


    <jsp:forward>标签用于把请求转发给另外一个资源
    语法：<jsp:forward page="relative URL |<%=expression%" />

    RequestDispatcher.forward 方法 PageContext.forward方法 <jsp:forward>标签的区别
    调用RequestDispatcher.forward方法的JSP脚本代码的前后不能有JSP模版内容；
    调用PageContext.forward 方法的JSP脚本代码的后面不能有JSP模版内容；
    <jsp:forward>标签的前后都能有JSP的模版内容，但<jsp:forward>可以使用
    jsp:param子标签向里面传入一些参数，同样jsp:include也可以

--%>

<jsp:include page="jspInclude2.jsp" flush="true" >
        <jsp:param name="username" value="wukang"></jsp:param>
        <%--这里会将wukang 输出到页面，因为jspInclude2.jsp，获取了--%>
</jsp:include>
    <%--<jsp:forward page="/jspInclude2.jsp">--%>
        <%--<jsp:param name="username" value="abcd"></jsp:param>--%>

    <%--</jsp:forward>--%>

    <%--    这里就无法输出str--%>
    String str = " hello ";
%>
</body>
</html>
