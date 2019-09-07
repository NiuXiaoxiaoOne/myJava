package interfacesdemo.comparable;

/**
 * @author xiaozhou
 */
public class Student {

    private String name;
    private int age;
    private float score;
    public Student() {
    }
    public Student(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    public int getAge() {
        return age;
    }
    public float getScore() {
        return score;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setScore(float score) {
        this.score = score;
    }
    @Override
    public String toString() {
        return name + "\t" + age + "\t" + score;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this == obj) {
            return true;
        } else if (obj instanceof Student) {
            Student stu = (Student)obj;
            return this.name.equals(stu.name) && this.age == stu.age &&
                    this.score == stu.score;
        } else {
            return false;
        }
    }

    /*
    @Override
    public int compareTo(Student stu) {
        if (this.score > stu.score) {
            return -1;
        } else if (this.score < stu.score) {
            return 1;
        } else {
            if (this.age > stu.age) {
                return 1;
            } else if (this.age < stu.age) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    */
}
