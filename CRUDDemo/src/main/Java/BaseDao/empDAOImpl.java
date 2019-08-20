package BaseDao;

import entity.Emp;

import java.util.List;

/**
 * @author bberzhou@gmail.com
 * @date 7/29/19 20:16
 * Create By IntelliJ IDEA
 */
public class empDAOImpl extends DAO<Emp> implements empDAO {
    @Override
    public List<Emp> getAll () {
        return null;
    }

    @Override
    public void save (Emp emp) {

    }

    @Override
    public Emp get (String name) {
        return null;
    }

    @Override
    public void delete (String name) {

    }

    @Override
    public long getCountWithName (String name) {
        return 0;
    }
}
