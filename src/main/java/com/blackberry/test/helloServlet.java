package com.blackberry.test;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author bberzhou@gmail.com
 * @date 7/22/19 21:45
 * Create By IntelliJ IDEA
 */
public class helloServlet extends HttpServlet {
    private String message;

    public void init () throws ServletException {
        message = "hello world blackberry";

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();

        out.print ("<h1>"+message+"<h1>");
    }

    public void destroy () {

    }
}
