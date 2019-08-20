package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bberzhou@gmail.com
 * @date 8/13/19 14:19
 * Create By IntelliJ IDEA
 */
public class TestAjax extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.setAttribute ("msg","<h1>hhhhh</h1>");
      req.getRequestDispatcher ("AjaxTest.jsp").forward (req,resp);

    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
