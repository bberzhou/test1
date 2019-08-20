package DAO;

import entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bberzhou@gmail.com
 * @date 7/28/19 15:08
 * Create By IntelliJ IDEA
 */
public class StudentDAO {
    //  获取所有的学生
    public List<Student> getAll() throws ClassNotFoundException {
        //  new 一个ArrayList
        List<Student> students = new ArrayList<> ();

        try {
            //  加载 驱动获取数据库连接
            String forName = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8&useSSL=true\n";
            String user = "root";
            String psd = "123456";
            Class.forName (forName);
            Connection connection = DriverManager.getConnection (url,user,psd);
            //  sql语句
            String  sql ="SELECT s.name,s.sex,s.score from s" ;
            PreparedStatement ps = connection.prepareStatement (sql);
            //  返回结果集
            ResultSet rs = ps.executeQuery ();
            //  遍历
            while (rs.next ()){
                String  name = rs.getString (1);
                String  sex = rs.getString (2);
                int score = rs.getInt (3);
                //  new 一个student,并传入参数name,sex,score
                Student student = new Student (name,sex,score);
                //  将student添加到list
                students.add (student);

                //  关闭数据库连接

            }
            if (rs != null){
                rs.close ();
            }
            if (ps != null){
                ps.close ();
            }
            if (connection != null){
                connection.close ();
            }


        }catch (SQLException e) {

            e.printStackTrace ();

        }

        //  返回一个List
        return students;


    }

    //  根据姓名删除学生信息
    public void deleteByName(String name) throws ClassNotFoundException {

        try {
            //  加载 驱动获取数据库连接
            String forName = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8&useSSL=true\n";
            String user = "root";
            String psd = "123456";
            Class.forName (forName);
            Connection connection = DriverManager.getConnection (url,user,psd);
            //  sql语句
            String  sql ="DELETE from s where s.name=?" ;
            PreparedStatement ps = connection.prepareStatement (sql);
            ps.setString (1,name);
            ps.execute ();

            if (ps != null){
                ps.close ();
            }
            if (connection != null){
                connection.close ();
            }


        }catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    //  添加学生
    public void InsertStu(Student student) throws ClassNotFoundException {


        try {
            //  加载 驱动获取数据库连接
            String forName = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8&useSSL=true\n";
            String user = "root";
            String psd = "123456";
            Class.forName (forName);
            Connection connection = DriverManager.getConnection (url,user,psd);
            //  sql语句
            String  sql ="INSERT into  s(name,sex,score) values (?,?,?)" ;
            String name=student.getName ();
            String sex = student.getSex ();
            int score = student.getScore ();
            PreparedStatement ps = connection.prepareStatement (sql);
            ps.setString (1,name);
            ps.setString (2,sex);
            ps.setInt (3,score);
            ps.executeUpdate ();
            if (ps != null){
                ps.close ();
            }
            if (connection != null){
                connection.close ();
            }


        }catch (SQLException e) {
            e.printStackTrace ();
        }
    }

}
