package Utils;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;


/**
 * @author bberzhou@gmail.com
 * @date 8/1/19 16:10
 * Create By IntelliJ IDEA
 */
public class DBUtils {

    @Test
    public void testPool () throws SQLException, IOException, ClassNotFoundException {
        Connection connection = DBUtils.getConnection ();
        System.out.println (connection);//   成功连接

    }

    //  利用连接池来获取数据库连接，数据库连接池只需要被初始化一次
    private static DataSource dataSource = null;

    static {
        dataSource = new ComboPooledDataSource ("helloc3p0");

    }

    /*
        获取数据库连接的方法
     */
    public static Connection getConnection () throws IOException, ClassNotFoundException, SQLException {
        //  此段代码就可以不需要了
//        Properties properties = new Properties ();
//        InputStream in = DBUtils.class.getClassLoader ().getResourceAsStream ("main/blackberry/ReviewJDBC/jdbc.properties");
//        properties.load (in);
//
//        String user = properties.getProperty ("user");
//        String password = properties.getProperty ("password");
//        String url = properties.getProperty ("url");
//        String driverClass = properties.getProperty ("diverClass");
//        //  加载驱动
//        Class.forName (driverClass);
//        Connection conn = DriverManager.getConnection (url, user, password);
//        return conn;

        return dataSource.getConnection ();


    }

    /*
        释放数据库资源
     */
    public static void releaseDB (ResultSet resultSet, Statement statement, Connection connection) {

        if (resultSet != null) {
            try {
                resultSet.close ();
            } catch (SQLException e) {
                e.printStackTrace ();
            }
        }
        if (statement != null) {
            // 4.关闭statement对象
            try {
                statement.close ();
            } catch (SQLException e) {
                e.printStackTrace ();
            }
        }
        if (connection != null) {
            // 5。关闭Connection对象
            try {
                //  数据库连接池的connection对象，close时并不是真的关闭，而是把该数据库连接归还到连接池
                connection.close ();
            } catch (SQLException e) {
                e.printStackTrace ();
            }
        }
    }


    //  处理数据库事务的相关方法
    //提交事务
    public static void commit (Connection conn) {
        if (conn != null) {
            try {
                conn.commit ();

            } catch (SQLException e) {
                e.printStackTrace ();
            }
        }

    }

    //回滚事务
    public static void rollback (Connection conn) {
        if (conn != null) {
            try {
                conn.rollback ();
            } catch (SQLException e) {
                e.printStackTrace ();
            }
        }

    }

    //开始事务
    public static void beginTransaction (Connection conn) {
        if (conn != null) {
            try {
                conn.setAutoCommit (false);
            } catch (SQLException e) {
                e.printStackTrace ();
            }
        }

    }

    /*
        不能执行select 操作
     */
    public static void update (String sql) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = getConnection ();
            statement = connection.createStatement ();
            statement.executeUpdate (sql);

        } catch (Exception e) {
            e.printStackTrace ();
        } finally {
            releaseDB (null, statement, connection);
        }
    }

    //采用PrepareStatement方式的update

    /**
     * 执行SQL语句，使用PrepareStatement
     *
     * @param sql
     * @param args:填写SQL占位符的可变参数，这里比数组更方便，需要几个参数就写几个参数
     */
    public static void update2 (String sql, Object... args) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBUtils.getConnection ();
            ps = connection.prepareStatement (sql);
            for (int i = 0 ; i < args.length ; i++) {
                //  遍历args,并将参数赋值给占位符，但是index是从1开始，而args数组是从0开始，所有需要 i+1

                ps.setObject (i + 1, args[i]);

            }
            //  执行sql语句
            ps.executeUpdate ();
        } catch (Exception e) {
            e.printStackTrace ();
        } finally {
            //  关闭数据库连接
            DBUtils.releaseDB (null, ps, connection);
        }

    }


    /**
     * 通用查询方法，可以根据传入的SQL、class对象返回SQL对应的记录的对象
     *
     * @param tClass 描述对象的类型
     * @param sql    传入SQL语句，可能带有占位符
     * @param args   填充占位符的可变参数
     * @param <T>
     * @return
     */
    public <T> T select (Class<T> tClass, String sql, Object... args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        T entity = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;


        try {

            conn = DBUtils.getConnection ();
            ps = conn.prepareStatement (sql);
            for (int i = 0 ; i < args.length ; i++) {
                ps.setObject (i + 1, args[i]);
            }

            rs = ps.executeQuery ();
            /*
                ResultSetMetaData元数据,可以从结果集中获取到结果集中有多少列，列名是什么

                getColumnCount ()可以获取SQL语句中包含哪些列
                getColumnLable(int column):获取指定的列的别名，索引从1开始
                getColumnName(int column):获取指定列的名称

             */

            /*
                    1。获取数据库连接，得到ResultSet对象，
                    2。得到ResultSetMetaData对象
                    3。创建一个Max<String,Object>对象， 键：是SQL查询的列名，值：是列的值
                    4。处理结果集，利用ResultSetMetaData填充3对应的对应的Map
                    5。若map不是空集，利用反射创建tclass对应的对象
                    6。遍历Map对象，利用反射为Class 对象的对应的属性赋值。
             */


            ResultSetMetaData metaData = rs.getMetaData ();
            int columnLength = metaData.getColumnCount ();
            if (rs.next ()) {
                //  利用反射创建对象
                entity = tClass.newInstance ();
                //  通过解析SQL语句来判断到底选择了哪些列，以及需要对对象的哪些属性赋值
                //  遍历获取每列的列名
                for (int i = 0 ; i < columnLength ; i++) {

                    String coName = metaData.getColumnName (i + 1);
                    System.out.println (coName);
                    //  得到每一的值
                    Object coValue = rs.getObject (coName);
                    if (coValue == null) {
                        coValue = "";
                    }
                    Field field = tClass.getDeclaredField (coName);
                    field.setAccessible (true);
                    //  将值赋给对象
                    field.set (entity, coValue);

                }

            }
        } catch (IOException e) {
            e.printStackTrace ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        } finally {
            DBUtils.releaseDB (null, ps, conn);
        }

        return entity;
    }
//
//    @Test
//    public void testSelect () throws InstantiationException, IllegalAccessException, NoSuchFieldException {
//        String sql = "select * from s where score=?";
//        Student student = select (Student.class, sql, 77);
//        System.out.println (student);
//        String sql1 = "Select * from s";
//        Student s = select (Student.class, sql1);
//        System.out.println (s);
//    }
//
//
//    @Test
//    public void testResultSetMeta () {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        String sql = "select * from s where score =?";
//
//        try {
//            conn = DBUtils.getConnection ();
//            ps = conn.prepareStatement (sql);
//            ps.setObject (1, 77);
//            rs = ps.executeQuery ();
//
//
//            ResultSetMetaData metaData = rs.getMetaData ();
//            int columnLength = metaData.getColumnCount ();
//            Map<String, Object> values = new HashMap<String, Object> ();
//            if (rs.next ()) {
//
//
//                for (int i = 0 ; i < columnLength ; i++) {
//                    //  获取列名
//                    String coName = metaData.getColumnName (i + 1);
//                    System.out.println (coName);
//                    //  得到每一列的值
//                    Object coValue = rs.getObject (coName);
//                    System.out.println (coValue);
//                    //  将结果放到map里面，键值对
//                    values.put (coName, coValue);
//                    if (coValue == null) {
//                        coValue = "";
//                    }
//
//                }
//                System.out.println (values);
//                Class clazz = Student.class;
//                //  利用反射创建一个对象
//                Object object = clazz.newInstance ();
//                //  遍历map
//                for (Map.Entry<String, Object> entry : values.entrySet ()) {
//                    //  得到列名和值
//                    String fieldName = entry.getKey ();
//                    Object fieldValue = entry.getValue ();
//                    //
//                    Field field = clazz.getDeclaredField (fieldName);
//                    field.setAccessible (true);
//                    //  给对象赋值
//                    field.set (object, fieldValue);
//                }
//                //  打印对象
//                System.out.println (object);
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace ();
//
//        } finally {
//            DBUtils.releaseDB (null, ps, conn);
//        }
//
//
//    }
}

