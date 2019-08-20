import DAO.StuDao;
import DAO.StuDaoImpl;
import entity.Student;
import org.junit.Test;

/**
 * @author bberzhou@gmail.com
 * @date 8/9/19 17:00
 * Create By IntelliJ IDEA
 */
public class testupdate {
    @Test
    public void testUpdate () {
        StuDao stuDao = new StuDaoImpl ();
        Student student = new Student ("kk", "男", 999);
        stuDao.update (student);
    }

}
