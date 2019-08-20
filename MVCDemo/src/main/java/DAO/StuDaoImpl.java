package DAO;

import entity.Student;

import java.util.List;

/**
 * @author bberzhou@gmail.com
 * @date 8/7/19 19:46
 * Create By IntelliJ IDEA
 */
public class StuDaoImpl extends Dao<Student> implements StuDao {


    @Override
    public List<Student> getAll () {
        String sql  ="select * from s";
        return getForList (sql);
    }

    @Override
    public void add (Student student) {
        String sql ="insert into s(name,sex,score) values(?,?,?)";
        update (sql,student.getName (),student.getSex (),student.getScore ());

    }

    @Override
    public Student updateByName (String name) {
        String sql ="select * from s where name=?";
        return get (sql,name);
    }

    @Override
    public void deleteByName (String name) {
        String sql = "delete from s where name=?";
        update (sql,name);

    }

    @Override
    public long getCountWithName (String  name) {
        String sql = "select count(score) from s where name=?";
        return getForValue (sql,name);
    }
    //  模糊查询的SQL
    @Override
    public List<Student> getForListWithCriteria (Student student) {
        String sql = "select name,sex,score from s where name like ? and sex like ? and score like ?";
        return getForList (sql,
            student.getName ()== null ? "%%" :"%"+student.getName ()+"%",
            student.getSex ()== null ? "%%" :"%"+student.getSex ()+"%",
            student.getScore ()== 0 ? "%%" :"%"+student.getScore ()+"%");
//        return getForList (sql,criteria.getName (),criteria.getSex (),
//            criteria.getScore ()== 0 ? "%%":"'%"+criteria.getScore ()+"%'");

    }

    @Override
    public void update (Student student) {
        String sql = "update s set sex=?,score=? where name=?";
        update (sql,student.getSex (),student.getScore (),student.getName ());

    }
}
