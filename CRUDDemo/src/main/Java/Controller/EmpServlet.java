package Controller;

import BaseDao.JdbcService.EmpJDBCService;
import BaseDao.JdbcService.EmpJDBCServiceImpl;
import entity.Emp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author bberzhou@gmail.com
 * @date 7/30/19 14:38
 * Create By IntelliJ IDEA
 */
public class EmpServlet extends HttpServlet {
    private EmpJDBCService dao = new EmpJDBCServiceImpl ();

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost (req,resp);

    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding ("UTF-8");
        //  判断用户执行的操作
        String actions = req.getParameter ("actions");
        if(actions.equals ("addEmp")){
            addEmp (req,resp);
        }else if(actions.equals ("selAllEmp")){
            selAllEmp (req,resp);
        }else if(actions.equals ("delEmp")){
            delEmp (req,resp);
        }else if (actions.equals ("updateEmp")){
            updateEmp (req,resp);

        }
    }

    private void addEmp(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        System.out.println ("用于要添加一个学生");
        String name = req.getParameter ("name");
        String sex = req.getParameter ("sex");
        int score = Integer.parseInt (req.getParameter ("score"));
        Emp emp = new Emp (name,sex,score);
        int i =dao.insert (emp);
        if(i>0){
            selAllEmp (req,resp);
        }

    }

    //  根据name删除emp

    private void delEmp(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        //  获取要删除员工的name
        String name = req.getParameter ("name");
        System.out.println("要删除的员工姓名:"+name);

        Emp emp = new Emp ();
        if (emp != null){
            emp.setName (name);
        }
        int i =dao.delete (emp);

        if (i>-1){


        }
        resp.sendRedirect ("success.jsp");
    }

    //  查找所有emp

    private void selAllEmp(HttpServletRequest req,HttpServletResponse resp) throws  IOException {
        System.out.println("查询所有学生");

        // 调用JDBC里面的查询服务
        List<Emp> list = dao.selectAll ();
        System.out.println(list);

        //  将emp的list集合存放到容器中去
        req.getSession ().setAttribute ("listEmp",list);
        //重定向到指定的页面
//        req.getRequestDispatcher ("showEmp.jsp").forward (req,resp);
        resp.sendRedirect ("showEmp.jsp");
    }
    public void updateEmp(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        System.out.println ("更新学生信息");
        String  name = req.getParameter ("name");

        Emp emp = new Emp ();
        emp.setName (name);
        req.getSession ().setAttribute ("updateEmp",emp);

        String sex = req.getParameter ("sex");
        String score = req.getParameter ("score");
        System.out.println(name);
        System.out.println(sex);
        System.out.println(score);

        dao.update (emp);

    }
}
