package Servlet;

import DAO.StuDao;
import DAO.StuDaoImpl;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author bberzhou@gmail.com
 * @date 8/8/19 09:39
 * Create By IntelliJ IDEA
 */
public class StudentServlet extends HttpServlet {
    public StudentServlet () {
        super ();
    }

    private StuDao stuDao = new StuDaoImpl ();

    @Override
    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost (req, resp);


    }
    /*
        根据前端请求的method参数来决定需要执行哪一个操作，但是这样会暴露到url不太安全

     */

//    @Override
//    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String method = req.getParameter ("method");
//        switch (method) {
//            case "delete":
//                Delete (req, resp);
//                break;
//            case "update":
//                Update (req, resp);
//                break;
//            case "query":
//                Query (req, resp);
//                break;
//
//        }
//    }

    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //  获取ServletPath :update.do
        String servletPath = req.getServletPath ();
//        System.out.println(servletPath);      //  返回值是  /updateStudent.do

        //  将请求的  / 和后面的 .do去掉之后，直接获得update等
        String methodName = servletPath.substring (1);
        methodName = methodName.substring (0, methodName.length () - 3);
        System.out.println (methodName);
        //  再利用反射，获取methodName对应的方法，
        try {
            Method method = getClass ().getDeclaredMethod (methodName, HttpServletRequest.class, HttpServletResponse.class);
            //4.利用反射调用对应的方法
            method.invoke (this, req, resp);
        } catch (Exception e) {
            resp.sendRedirect ("error.jsp");
        }

    }


    public void Query (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  获取查询的请求参数
//        req.setCharacterEncoding ("UTF-8");
//        String name = req.getParameter ("name");
//        String sex = req.getParameter ("sex");
//        int score = Integer.parseInt (req.getParameter ("score"));
//        System.out.println (name);
//        System.out.println (sex);
//        System.out.println (score);
//        Student student = new Student (name, sex, score);


        List<Student> students = stuDao.getAll ();
//        List<Student> students = stuDao.getForListWithCriteria (student);

        //  把stu的集合放入到request中
        req.setAttribute ("students", students);

        //  转发页面到index.jsp
        req.getRequestDispatcher ("index.jsp").forward (req, resp);


    }


    public void Delete (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter ("name");
        stuDao.deleteByName (name);
        response.sendRedirect ("Query.do");
    }


    public void Update (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding ("UTF-8");
        // 获取表单参数，
        String name = request.getParameter ("name");
        String sex = request.getParameter ("sex");
        int score = Integer.parseInt (request.getParameter ("score"));
        String oldName = request.getParameter ("oldName");
        //  如果修改了name之后，才在数据库中查找是否已经被使用
        if (!oldName.equals (name)){
            long count = stuDao.getCountWithName (name);
            if (count>0){
                request.setAttribute ("message","用户"+name+"已经被占用！");
                request.getRequestDispatcher ("updateStudent.jsp").forward (request,response);
            }else {
                Student student = new Student (name,sex,score);
                stuDao.add (student);
                response.sendRedirect ("Query.do");
            }

        }else if (oldName.equals (name)){
            Student student = new Student (name,sex,score);
            stuDao.update (student);
            response.sendRedirect ("Query.do");

        }


        System.out.println ("Update");
    }

    private void Add (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //  设置字符编码
        request.setCharacterEncoding ("UTF-8");
        //  获取表单参数
        String name = request.getParameter ("name");
        String sex = request.getParameter ("sex");
        int score = Integer.parseInt (request.getParameter ("score"));
        Student student = new Student (name, sex, score);
//        System.out.println(name+sex+score);
        //  判断数据库中是否已经有此用户名
        if (stuDao.getCountWithName (name) > 0) {
//            request.getRequestDispatcher ("addNewStudent.jsp");
            //  如果数据库中存在，则重定向到添加页面，并且回显输入框中信息
            request.setAttribute ("message", "用户名" + name + "已经被占用，请重新输入");
            request.getRequestDispatcher ("addNewStudent.jsp").forward (request, response);


        } else {
            //  如果数据库中没有就添加，然后重定向到首页（用不着请求域中的属性时，就可以使用重定向）
            stuDao.add (student);
            response.sendRedirect ("Query.do");
            //  使用重定向可以避免出现表单的重复提交的问题，
        }
    }


    //  修改方法
    private void Edit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //  1.获取请求参数
        String name = request.getParameter ("name");
        //  获取对应的对象
        Student students = stuDao.updateByName (name);
        System.out.println(students.toString ());
        //  将对象放入到请求域中用于回显
        request.setAttribute ("stu",students);
        request.getRequestDispatcher ("updateStudent.jsp").forward (request,response);
//        response.sendRedirect ("updateStudent.jsp");

        //
    }

}
