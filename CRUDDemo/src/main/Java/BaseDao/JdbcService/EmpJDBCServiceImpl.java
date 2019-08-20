package BaseDao.JdbcService;

import DBUtils.DBUtil;
import entity.Emp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bberzhou@gmail.com
 * @date 7/30/19 14:40
 * Create By IntelliJ IDEA
 */
public  class EmpJDBCServiceImpl extends DBUtil implements EmpJDBCService {


    @Override
    public int insert (Emp emp) {
        //  需要执行的插入sql语句
        String sqls = "insert into s(name,sex,score) values(?,?,?)";
        //  参数
        Object[] params = {emp.getName (),emp.getSex (),emp.getScore ()};
        return doUpdate (sqls,params);
    }

    @Override
    public int delete (Emp emp) {
        String sqls = "delete from s where name=?";
        Object[] params = {emp.getName ()};
        return doUpdate (sqls,params);
    }

    @Override
    public int update (Emp emp) {
        String sqls = "update s set name=?,score=?";
        Object[] params = {emp.getSex (),emp.getScore ()};
        return  doUpdate (sqls,params);
    }


    @Override
    public List<Emp> selectAll () {
       //   查询所有
        String sqls ="SELECT * FROM s ";
        ResultSet rs = doQuery (sqls,null);

        //  存放emp信息的list
        List<Emp> emps = new ArrayList<> ();
        try {
            if (rs.next ()){    //如果为true,表明至少有一条语句
                rs.beforeFirst ();

                while ((rs.next ())){
                    String  name = rs.getString (1);
                    String  sex = rs.getString (2);
                    int score = rs.getInt (3);
                    Emp emp = new Emp (name,sex,score);
                    emps.add (emp);  //把每个emp 对象放到list里面
                }

            }

        }catch (SQLException e){
            e.printStackTrace ();
        }
        return emps;    //返回一个list
    }

    @Override
    public Emp selectByName (Emp emp) {
        return null;
    }
}



