<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: zhouzhaojian
  Date: 8/20/19
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用cookie来显示最近的5条book信息</title>
</head>
<body>
<%--
    把书的信息以cookie的方式回传给浏览器，并删除一个 cookie
    1。确定要被删除的Cookie，myBooks开头的cookie数量大于或者等于5，
        删除规则，如果从books.jsp中传入的book不在myBooks的cookie中删除较早的那个，
        （即是数组中的第一个），如果在其中就删除该cookie
   2.把从books.jsp传入的book作为一个cookie返回
       --%>
<h3>Book DetailPage</h3>
Book:<%= request.getParameter ("book")%><br><br>
<a href="books.jsp">Return</a>

<%


    //1。确定要被删除的Cookie，myBooks开头的cookie数量大于或者等于5，
    // 删除规则，如果从books.jsp中传入的book不在myBooks的cookie中删除较早的那个，
    //（即是数组中的第一个），如果在其中就删除该cookie


    String book = request.getParameter ("book");
    //  把书的信息以cookie的方式传回给浏览器，删除一个cookie
    Cookie[] cookies = request.getCookies ();
    //  保存所有的myBooks开头的cookie
    List<Cookie> bookCookies = new ArrayList<> ();
    //  用来保存和books.jsp传入的book匹配的那个cookie
    Cookie tempCookie = null;
    if (cookies != null && cookies.length > 0) {
        for (Cookie cookie : cookies) {
            String cookieName = cookie.getName ();
            if (cookieName.startsWith ("myBooks")) ;
            //  如果是以myBooks开头就把这个cookie放入到list中
                bookCookies.add (cookie);
                //  如果equal则将tempCookie = cookie
                if (cookie.getValue ().equals (book)){
                    tempCookie = cookie;

                }

        }
    }
    // 删除规则，如果从books.jsp中传入的book不在myBooks的cookie中删除较早的那个，
    //（即是数组中的第一个），如果在其中就删除该cookie
    if (bookCookies.size ()>=5 && tempCookie == null){
        tempCookie = bookCookies.get (0);

    }
    //  若在其中，则删除该cookie
    if (tempCookie != null){
        tempCookie.setMaxAge (0);
        response.addCookie (tempCookie);
    }
    //2。把从books.jsp传入的book作为一个cookie返回
    Cookie cookie = new Cookie ("myBooks" + book, book);
    response.addCookie (cookie);

%>
</body>
</html>
