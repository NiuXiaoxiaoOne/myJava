package enumdemo;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author xiaolei
 * 使用Comparable, 进行排序操作
 */
enum Color3 {
    RED, GREEN, BLUE;
}
/**
 * @author xiaolei
 */
public class DerivedClass3 {
    public static void main(String[] args) {
        Set<Color3> t = new TreeSet<Color3>();
        t.add(Color3.GREEN);
        t.add(Color3.RED);
        t.add(Color3.BLUE);
        Iterator<Color3> iter = t.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
    }
}
