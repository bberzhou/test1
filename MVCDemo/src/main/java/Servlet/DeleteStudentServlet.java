package Servlet;

import DAO.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bberzhou@gmail.com
 * @date 7/28/19 16:43
 * Create By IntelliJ IDEA
 */
public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  获取请求中的参数name
        String name = req.getParameter ("name");
        StudentDAO studentDAO = new StudentDAO ();
        try {
            studentDAO.deleteByName (name);
            req.getRequestDispatcher ("/success.jsp").forward (req,resp);

        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }


    }
}
