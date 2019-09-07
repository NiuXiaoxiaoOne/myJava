package interfacesdemo.comparable;

public class TStudent {
    public static void main(String[] args) {
        Student[] stu = {new Student("aa", 20, 90.0f),
                new Student("bb", 21, 90.0f),
                new Student("cc", 20, 100.0f),
                new Student("dd", 17, 90.0f),};
        java.util.Arrays.sort(stu, new StudentComparator());

        for (int i = 0; i < stu.length; i ++) {
            System.out.println(stu[i]);
        }
    }
}
