<%@ page import="java.text.CollationKey" %><%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 8/20/19
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>测试cookie时效</h2>
<%
    //  若可以请求到参数name，则打印出欢迎信息，并将信息存储到Cookie中，设置cookie的时效为30s
    String name = request.getParameter ("name");
    if (name != null && !name.trim ().equals ("")){
        out.println ("hello"+name);
        Cookie cookie = new Cookie ("name",name);
        cookie.setMaxAge (30);
        response.addCookie (cookie);
    }else {
        //  从Cookie中读取用户信息，若存在就打印欢迎信息
        Cookie[] cookies = request.getCookies ();
        if (cookies != null && cookies.length>0){
            for (Cookie cookie: cookies) {
                String cookieName = cookie.getName ();
                if ("name".equals (cookieName)){
                    String val = cookie.getValue ();
                    name = val;

                }
                
            }
        }

    }
    //  如果name存在且不为空，则打印name，否则重定向到login.jsp
    if (name != null && !name.trim ().equals ("")){
        out.println ("Hello "+name);

    }else {
        response.sendRedirect ("login.jsp");
    }

%>

</body>
</html>
