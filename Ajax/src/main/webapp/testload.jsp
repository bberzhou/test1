<%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 8/22/19
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试load</title>
</head>
<script type="text/javascript" src="jsfile/jquery-3.3.1.js"></script>

<script type="text/javascript">
    $(function () {
      $("a").click(function () {
        //  使用load方法处理Ajax
        var url = this.href;
        var args = {
          "time":new Date()
        };
        //  load方法会根据有无参数自动决定是post请求还是get请求，有参数post请求，无参数就是post请求
        $("#content").load(url,args);
        //  关闭默认行为
        return false;
      })
    })
</script>
<body>
<%--点击之后将响应内容插入到div--%>
<a href="helloAjax.txt">helloAJax</a>
<div id="content"></div>

</body>
</html>
