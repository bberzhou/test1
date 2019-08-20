package BaseDao.JdbcService;

import entity.Emp;

import java.util.List;

/**
 * @author bberzhou@gmail.com
 * @date 7/30/19 14:40
 * Create By IntelliJ IDEA
 */
public interface EmpJDBCService {
    /**
     * 添加用户
     */
    public int insert(Emp emp);
    /**
     * 删除用户
     */
    public int delete(Emp emp);
    /**
     * 修改用户
     */
    public int update(Emp emp);
    /**
     * 查询所有员工
     */
    public List<Emp> selectAll();
    /**
     * 根据姓名查询
     */
    public Emp selectByName(Emp emp);
}
