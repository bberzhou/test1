package com.blackberry.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @author bberzhou@gmail.com
 * @date 7/26/19 10:53
 * Create By IntelliJ IDEA
 */
public class LoginServlet3 extends HttpServlet {
    /*

     */

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  设置请求对象的编码，注意：只可以将这段代码放到函数的第一行，且这是POST方式专属的
        req.setCharacterEncoding ("UTF-8");

        String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8&useSSL=true\n";
        String user = "root";
        String psd = "123456";
        String username = req.getParameter ("username");
        String password = req.getParameter ("password");
        //  sql语句

        String sql = "SELECT count(*) FROM test WHERE user=?"+"AND password=?";

        try {
            //  获取数据库连接
            Class.forName ("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection (url,user,psd);
            PreparedStatement preparedStatement = connection.prepareStatement (sql);
            preparedStatement.setString (1,username);
            preparedStatement.setString (2,password);
            //  返回 结果集
            ResultSet resultSet = preparedStatement.executeQuery ();
            //  PrintWriter 对象，在屏幕上打印
            PrintWriter printWriter = resp.getWriter ();
            while (resultSet.next ()){
                System.out.println(resultSet.getString (1));
            }

            if (resultSet.next ()){
                int count = resultSet.getInt (1);
                if(count>0){
                    printWriter.print ("hello"+username);
                }else {
                    printWriter.println ("sorry"+username);
                }
//                try {
//
//                    //  关闭连接
//
//                    if (resultSet != null){
//                        resultSet.close ();
//                    }
//                    if (preparedStatement != null){
//                        preparedStatement.close ();
//                    }
//                    if (connection != null){
//                        connection.close ();
//                    }
//                }catch (SQLException s){
//                    s.printStackTrace ();
//                }

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace ();
        }


    }
}
