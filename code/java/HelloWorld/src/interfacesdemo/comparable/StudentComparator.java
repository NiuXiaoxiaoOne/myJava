package interfacesdemo.comparable;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.equals(s2)) {
            return 0;
        } else if (s1.getScore() < s2.getScore()) {
            return 1;
        } else {
            return -1;
        }
    }
}
