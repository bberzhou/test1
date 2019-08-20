<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 8/13/19
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学习Ajax</title>
</head>
<script type="text/javascript" >
    function test1_Ajax() {
        //    1。携带参数的形式
        $.get("TestAjax",{"name":"kkk","password":"123456"})

    // }
    // //  响应一般数据
    // function test3_Ajax() {
    //     $.get("TestAjax",{},function (data) {
    //         alert(data);
    //     })
    //
    // }

    /*
        $.get(url,[data],[callback],[type]),get请求
        url:待载入页面的URL地址
        data:待发送key/value参数
        callback:载入成功时回调函数
        type:返回内容的格式，包括xml、html、script、json、text、
        []表示为可选参数

     */


</script>
<body>
<%=new Date()%>
<a href="/TestAjax">获取信息</a>
<div>
    显示信息
</div>
</body>
</html>
