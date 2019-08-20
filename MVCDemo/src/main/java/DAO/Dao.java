package DAO;

import Utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

/**
 * @author bberzhou@gmail.com
 * @date 8/7/19 19:28
 * Create By IntelliJ IDEA
 */

/*
    封装类基本的CRUD的方法，以供子类继承使用
    当前DAO直接在方法中获取数据库连接
    整个DAO采取DBUtils
    <T> 当前DAO处理的实体类的类型是什么
 */
public class Dao<T> {
    private Class<T> tClass;
    private QueryRunner queryRunner = new QueryRunner ();

    //  利用反射返回一个对象
    public Dao () {
        Type superClass = getClass ().getGenericSuperclass ();
        if (superClass instanceof ParameterizedType) {
            //  强转
            ParameterizedType parameterizedType = (ParameterizedType) superClass;
            Type[] typeArgs = parameterizedType.getActualTypeArguments ();
            if (typeArgs != null && typeArgs.length > 0) {
                if (typeArgs[0] instanceof Class) {
                    tClass = (Class<T>) typeArgs[0];
                }
            }

        }
    }

    /**
     * 此方法封装类INSERT、DELETE、UPDATE操作
     *
     * @param sql：SQL语句
     * @param args：填充SQL语句的占位符
     */
    public void update (String sql, Object... args) {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection ();
            queryRunner.update (connection, sql, args);
        } catch (Exception e) {
            e.printStackTrace ();

        } finally {
            JDBCUtils.releaseConnect (connection);
        }

    }

    /**
     * 返回对应的T的一个实例对象。
     *
     * @param sql
     * @param args
     * @return
     */

    public T get (String sql, Object... args) {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection ();
            return queryRunner.query (connection,sql,new BeanHandler<> (tClass),args);

        } catch (Exception e) {
            e.printStackTrace ();
        } finally {
            JDBCUtils.releaseConnect (connection);
        }


        //  这个输出在test里面的testUpdateByName，可以看到利用反射创建的对象能成功输出
//        System.out.println(tClass);
        return null;
    }


    /**
     * 返回T所对应的List
     *
     * @param sql
     * @param args
     * @return
     */
    public List<T> getForList (String sql, Object... args) {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection ();
            return queryRunner.query (connection,sql,new BeanListHandler<> (tClass),args);

        } catch (Exception e) {
            e.printStackTrace ();
        } finally {
            JDBCUtils.releaseConnect (connection);
        }

        return null;
    }

    /**
     * @param sql
     * @param args
     * @param <E>
     * @return 返回某一个字段的值，例如返回某一条的记录为name,score等
     */

    public <E> E getForValue (String sql, Object... args) {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection ();
            return (E) queryRunner.query (connection,sql,new ScalarHandler(),args);

        } catch (Exception e) {
            e.printStackTrace ();
        } finally {
            JDBCUtils.releaseConnect (connection);
        }

        return null;
    }
}
