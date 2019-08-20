package Servlet;

import DAO.StudentDAO;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bberzhou@gmail.com
 * @date 7/29/19 20:22
 * Create By IntelliJ IDEA
 */
public class InsertStudentServlet extends HttpServlet {
    @Override
    protected void  doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding ("UTF-8");
        String  name = req.getParameter ("username");
        String sex = req.getParameter ("sex");
        int score = Integer.parseInt (req.getParameter ("score"));


        StudentDAO studentDAO = new StudentDAO ();
        Student student = new Student ();
        student.setName (name);
        student.setSex (sex);
        student.setScore (score);
//        student.setScore (Integer.parseInt (req.getParameter ("score")));
        System.out.println(name);
        System.out.println(sex);
        System.out.println(score);
        try {
            studentDAO.InsertStu (student);
            req.getRequestDispatcher ("/students.jsp").forward (req,resp);
        } catch (ClassNotFoundException e) {

            e.printStackTrace ();
        }

    }

}
