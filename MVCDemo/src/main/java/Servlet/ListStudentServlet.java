package Servlet;

import DAO.StudentDAO;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author bberzhou@gmail.com
 * @date 7/28/19 09:40
 * Create By IntelliJ IDEA
 */
public class ListStudentServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute ("student", Arrays.asList ("AAA","BBB"));
//        req.getRequestDispatcher ("/students.jsp").forward (req,resp);

        //  new 一个studentDAO对象
        StudentDAO studentDAO = new StudentDAO ();
        try {
            // studentDAO调用getAll方法 ，返回一个list
            List<Student> students = studentDAO.getAll ();
            //  使用request域对象设置Attribute，键值对的形式
            req.setAttribute ("students",students);
            //  转发请求，因为是采用的转发请求，所以student,jsp可以使用内置对象获取到Attribute
            //  若目标的响应页面不需要从request从读取任何值的时候，贼可以使用重定向，还可以防止表单的重复提交
            req.getRequestDispatcher ("/students.jsp").forward (req,resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }

    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
