import Utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author bberzhou@gmail.com
 * @date 8/7/19 20:15
 * Create By IntelliJ IDEA
 */
public class connTest {
    @Test
    public void testGetConnection() throws SQLException {
        Connection connection = JDBCUtils.getConnection ();
        System.out.println(connection);
    }

}
