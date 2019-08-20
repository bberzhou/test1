package entity;

/**
 * @author bberzhou@gmail.com
 * @date 7/29/19 20:07
 * Create By IntelliJ IDEA
 */
public class Emp {
    private String name;
    private String sex;
    private int score;

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getSex () {
        return sex;
    }

    public void setSex (String sex) {
        this.sex = sex;
    }

    public int getScore () {
        return score;
    }

    public void setScore (int score) {
        this.score = score;
    }

//    无参的构造器
    public Emp () {
    }

    public Emp (String name, String sex, int score) {
        this.name = name;
        this.sex = sex;
        this.score = score;
    }

    @Override
    public String toString () {
        return "emp{" +
            "name='" + name + '\'' +
            ", sex='" + sex + '\'' +
            ", score=" + score +
            '}';
    }
}
