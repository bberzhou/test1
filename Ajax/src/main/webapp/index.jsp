<%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 8/9/19
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试Ajax</title>
</head>
<meta charset="UTF-8">
<script type="text/javascript">

    window.onload = function () {

        //  1。获取a节点，并为其添加onclick响应函数
       var test = document.getElementsByTagName("a")[0];

       test.onclick = function () {
           //   2。创建一个XMLHttpRequest对象
           var xml = new XMLHttpRequest();
           //   3。准备发送请求的数据：method和url
           var url = this.href;
           var method = "GET";
           //   4。调用XMLHttpRequest对象的open方法
           xml.open(method,url);
           //   5。调用XMLHttpRequest对象的send方法
           xml.send();

           //   6。为XMLHttpRequest对象添加onreadystatechange响应函数
           /*
                 XMLHttpRequest对象的相关属性和事件
                 status:200'OK'
                 responseText：获得字符串形式的响应数据
                 responseXML：获得XML形式的响应数据
                 readyState：
                 存有 XMLHttpRequest 的状态。请求发送到后台后，状态会从 0 到 4 发生变化。
                 0: 请求未初始化
                 1: 服务器连接已建立
                 2: 请求已接收
                 3: 请求处理中
                 4: 请求已完成，且响应已就绪
                 onreadystatechange: 每当readyState属性改变时，就会调用该函数。
                 */
           console.log(xml.readyState);
           xml.onreadystatechange = function () {
               if (xml.readyState == 4){
                   if (xml.status == 200 || xml.status == 304){
                       alert(xml.responseText);
                   }
               }

           }

       }

        //  取消默认行为
        return false;
    }

</script>
<body>
<a id="test" href="helloAjax.txt" >helloAjax</a>
</body>
</html>