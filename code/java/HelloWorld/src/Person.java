import java.util.HashSet;

/**
 * equals()的测试程序
 * @author d
 */

public class Person {

    public static class People {
        int age;
        String name;

        public People(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString(){
            return name + " - " + age;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            } else if (this == obj) {
                return true;
            } else if (this.getClass() != obj.getClass()) {
                return false;
            }
            if (obj instanceof People) {
                People people = (People) obj;
                return this.name.equals(people.name) && this.age == people.age;
            } else {
                return false;
            }

        }

        @Override
        public int hashCode() {
            int nameHash = this.name.toUpperCase().hashCode();
            return nameHash ^ this.age;
        }
    }

    public static void main(String[] args) {

        People p1 = new People("e", 100);
        People p2 = new People("e", 100);
        People p3 = new People("g", 210);

        HashSet set = new HashSet();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println(p1.equals(p2) +" " + p1.hashCode() + " " + p2.hashCode());
        System.out.println(set);

        Object ob = new Object();
        System.out.println(ob.toString());
        System.out.println(ob.getClass().getName());
    }

}
