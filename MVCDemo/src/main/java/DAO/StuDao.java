package DAO;

import entity.Student;

import java.util.List;

/**
 * @author bberzhou@gmail.com
 * @date 8/7/19 19:40
 * Create By IntelliJ IDEA
 */
public interface StuDao {
    //  查询所有
    List<Student> getAll ();

    //  添加操作
    void add (Student student);

    //  更新的时候根据姓名查出来之后再更新
    Student updateByName (String name);

    //  根据姓名删除
    void deleteByName (String name);

    //  查询有相同姓名的总数
    long getCountWithName (String name);

    //  模糊查询，为了方便，可以将输入的条件直接封装成一个单独的类
    List<Student> getForListWithCriteria(Student student);
    void update(Student student);
}
