package DBUtils;




import java.sql.*;

/**
 * @author bberzhou@gmail.com
 * @date 7/30/19 14:30
 * Create By IntelliJ IDEA
 */
public class DBUtil {

    private String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8&useSSL=false\n";
    private String user="root";
    private String password="123456";
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    /**
     * 加载驱动
     */
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接数据库的会话对象
     * @throws SQLException
     */

    public void getConn(){
        try {
            conn = DriverManager.getConnection (url,user,password);
            System.out.println("连接数据库成功。");
        } catch (SQLException e) {
            System.out.println("连接数据库失败。");
            e.printStackTrace();
        }
    }

    /**
     * 用于执行类似增删改的sql语句，如可以执行以下的sql语句：<br>
     * @参数1 String sqls<br>
     * 		sqls = "delete from 表名 where 字段名=?";<br>
     * 		sqls = "delete from 表名 where 字段名=字段值";<br>
     * 		sqls = "insert into 表名 values(?,?,?...)";<br>
     * 		sqls = "insert into 表名 values(字段名1=字段值1,字段名2=字段值2,字段名2=字段值2)";<br>
     *
     * @参数2 Object params []<br>
     * 		params={给占位符的值1，给占位符的值2，。。。。}
     */
    public int doUpdate(String sqls,Object params []) {
        //获取数据库的会话对象
        getConn();
        //影响行数
        int j = 0;
        try {
            //获取执行对象
            ps = conn.prepareStatement(sqls);
            //给占位符赋值
            for (int i = 0;params!=null && i < params.length;  i++) {
                ps.setObject(i+1, params[i]);
            }

            System.out.println("预编译的sql语句为："+ps.toString());

            //执行sql语句
            j = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return j;
    }
    /**
     * 用于执行类似增删改的sql语句，如可以执行以下的sql语句：<br>
     * @参数1 String sqls<br>
     * 		sqls = "delete from 表名 where 字段名=?";<br>
     * 		sqls = "delete from 表名 where 字段名=字段值";<br>
     * 		sqls = "insert into 表名 values(?,?,?...)";<br>
     * 		sqls = "insert into 表名 values(字段名1=字段值1,字段名2=字段值2,字段名2=字段值2)";<br>
     *
     * @参数2 Object params []<br>
     * 		params={给占位符的值1，给占位符的值2，。。。。}
     */
    public ResultSet doQuery(String sqls,Object params []) {
        //获取数据库的会话对象
        getConn ();
        //影响行数
        int j = 0;
        try {
            //获取执行对象
            ps = conn.prepareStatement (sqls);
            //给占位符赋值
            for (int i = 0; params !=null&&i< params.length;  i++) {
                ps.setObject(i+1, params[i]);
            }

            System.out.println("预编译的sql语句为："+ps.toString());

            //执行sql语句
            rs = ps.executeQuery();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return rs;

    }

    /**
     * 释放资源
     * 	先开启的对象后关闭，后开启的对象先关闭
     * 	链接数据库的会话对象   执行对象   结果集对象
     */
    public void getClose() {
        try {
            if (rs!=null) {
                rs.close();
            }
            if (ps!=null) {
                ps.close();
            }
            if (conn!=null) {
                conn.close();
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
