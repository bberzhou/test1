package entity;

/**
 * @author bberzhou@gmail.com
 * @date 7/28/19 15:09
 * Create By IntelliJ IDEA
 */
public class Student {
//     实体类，有name,sex,score 属性
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

    public Student (String name, String sex, int score) {
        this.name = name;
        this.sex = sex;
        this.score = score;
    }
    //  无参的构造器
    public Student(){};

    @Override
    public String toString () {
        return "Student{" +
            "name='" + name + '\'' +
            ", sex='" + sex + '\'' +
            ", score=" + score +
            '}';
    }
}
