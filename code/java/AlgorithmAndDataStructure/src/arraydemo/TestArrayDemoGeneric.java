package arraydemo;

import java.sql.SQLOutput;

/**
 * @author xiaolei
 */
class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }
}
/**
 * @author xiaolei
 * 用泛型测试student类
 */
public class TestArrayDemoGeneric {
    public static void main(String[] args) {
        ArrayDemoGeneric<Student> arr = new ArrayDemoGeneric<>();
        arr.addLast(new Student("Alice", 100));
        arr.addLast(new Student("Bob", 20));
        System.out.println(arr.get(0));
        System.out.println(arr);
    }

}
