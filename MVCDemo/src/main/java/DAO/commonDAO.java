package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author bberzhou@gmail.com
 * @date 8/7/19 14:24
 * Create By IntelliJ IDEA
 */


/*
    访问数据的DAO接口，里面定义好访问数据表的各种方法，T:DAO处理的实体类的类型
 */
public interface commonDAO<T> {


    /**
     *
     *  用于INSERT UPDATE，DELETE
     * @param connection：数据库连接
     * @param sql：SQL语句
     * @param args：填充占位符的可变参数
     */
    void update(Connection connection,String sql,Object...args);

    /**
     *
     * @param connection：数据库连接
     * @param sql:SQL语句
     * @param args
     * @return  返回一个T的对象
     */
    T get(Connection connection,String sql ,Object args) throws SQLException;

    /**
     *
     * @param connection：数据库连接
     * @param sql：SQL语句
     * @param args
     * @return  返回T的一个集合
     */
    List<T> getForList(Connection connection ,String sql,Object...args);


    /**
     *
     * @param connection：数据库连接
     * @param sql
     * @param args
     * @param <E>
     * @return  返回具体的一个值，如总的人数，某一个人的name等
     */
    <E> E getForValue(Connection connection,String sql,Object args);

    /**
     * 批量处理的方法，
     * @param connection
     * @param sql
     * @param args：填充占位符的Object[]类型的可变参数
     */
    void batch(Connection connection,String sql,Object[]...args);
}
