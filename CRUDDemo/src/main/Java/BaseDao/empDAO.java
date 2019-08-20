package BaseDao;

import entity.Emp;

import java.util.EnumMap;
import java.util.List;

/**
 * @author bberzhou@gmail.com
 * @date 7/29/19 20:07
 * Create By IntelliJ IDEA
 */
public interface empDAO {
    //  查询全部
    public List<Emp> getAll();
    //  保存
    public void save (Emp emp);
    //  根据 name查询
    public Emp get(String name);
    //  根据name 删除
    public void delete(String name);

    /**
     * 返回和name相等的记录，用来判断是否可以添加
     * @param name
     * @return
     */
    public long getCountWithName(String name);

}
