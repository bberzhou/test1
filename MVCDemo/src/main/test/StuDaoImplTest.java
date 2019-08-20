import DAO.StuDao;
import DAO.StuDaoImpl;
import entity.Student;
import org.junit.Test;

import java.util.List;

/**
 * @author bberzhou@gmail.com
 * @date 8/7/19 20:26
 * Create By IntelliJ IDEA
 */
public class StuDaoImplTest {
    private StuDao stuDao = new StuDaoImpl ();
    @Test
    public void testAdd () {
        Student student = new Student ();
        student.setName ("jian");
        student.setSex ("女");
        student.setScore (99);
        stuDao.add (student);



    }
    @Test
    public void testGetAll () {
        List<Student> students = stuDao.getAll ();
        System.out.println(students);

    }

    @Test
    public void testUpdateByName() {
        Student student = stuDao.updateByName ("kk");
        System.out.println(student);    //class entity.Student


    }

    @Test
    public void testDelete () {
        stuDao.deleteByName ("jian");

    }

    @Test
    public void testCount() {
        long count = stuDao.getCountWithName("周");
        System.out.println(count);

    }
}
