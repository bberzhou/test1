package Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author bberzhou@gmail.com
 * @date 8/7/19 19:37
 * Create By IntelliJ IDEA
 */
public class JDBCUtils {
    private static DataSource dataSource = null;

    //  数据源只需要被初始化一次就可以
    static {

        dataSource = new ComboPooledDataSource ("mvcApp");
    }

    //  获取数据库连接,返回一个connection对象
    public static Connection getConnection () throws SQLException {

        return dataSource.getConnection ();
    }

    /*
    释放数据库连接
 */
    public static void releaseConnect (Connection connection) {
        try {
            if (connection!= null){
                connection.close ();
            }
        }catch (Exception e){
            e.printStackTrace ();
        }

    }
}
