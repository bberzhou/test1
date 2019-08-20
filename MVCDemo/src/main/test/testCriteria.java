import DAO.StuDao;
import DAO.StuDaoImpl;
import entity.Student;
import org.junit.Test;

import java.util.List;

/**
 * @author bberzhou@gmail.com
 * @date 8/8/19 16:18
 * Create By IntelliJ IDEA
 */
public class testCriteria {
    private StuDao  stuDao = new StuDaoImpl();

    @Test
    public void test(){
//        Criteria criteria = new Criteria ("kk",null,0);
//        List<Student> students = stuDao.getForListWithCriteria (criteria);
//        System.out.println(students);//[Student{name='kk', sex='df', score=90}, Student{name='kkk', sex='df', score=90}, Student{name='kkkk', sex='女', score=999}, Student{name='kkkkkk', sex='女', score=999}]

        Student student = new Student ("n",null,0);
        List<Student> students1 = stuDao.getForListWithCriteria (student);
        System.out.println(students1);

    }

//    @Test
//    public void test1(){
//        Criteria criteria = new Criteria ();
//        List<Student> students = null;
//        if (criteria.getSex () == null && criteria.getName ()== null && criteria.getScore () ==0){
//             students = stuDao.getAll ();
//        }
//        else {
//            students = stuDao.getForListWithCriteria (criteria);
//        }
//        System.out.println(students);
//    }
}
