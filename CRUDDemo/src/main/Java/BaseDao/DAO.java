package BaseDao;

import java.util.List;

/**
 * 该类封装了基本的CRUD的方法，以提供给子类使用，当前DAO直接在方法中获取数据库连接
 * @param <T> 当前DAO处理的实体类的类型是什么
 * @author bberzhou@gmail.com
 * @date 7/29/19 19:47
 * Create By IntelliJ IDEA
 */
public class DAO<T>{



    /**
     * 该方法封装了INSERT,DELETE ,UPDATE操作
     * @param sql   sql 语句
     * @param args  填充sql语句的占位符
     */
    public void Update(String sql,Object ...args){

    }

    /**
     * 返回对应的 T 的一个实例类的对象
     * @param sql
     * @param args
     * @return
     */
    public T get(String sql,Object ... args){
        return  null;
    }

    /**
     * 返回T所对应的List
     * @param sql
     * @param args
     * @return
     */
   public List<T> getForList(String sql,Object ...args){
        return null;
   }


    /**
     * 返回某一个字段的值，例如返回某条记录的name，或者返回数据表中有多少条数据。
     * @param sql
     * @param args
     * @param <E>
     * @return
     */
   public <E> E getForValue(String sql,Object...args){
       return  null;
   }

    public Class<T> clazz;


}
