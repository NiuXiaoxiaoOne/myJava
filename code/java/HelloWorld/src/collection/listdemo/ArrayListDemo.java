package collection.listdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaolei
 */
public class ArrayListDemo {
    public static void main(String[] args) {

        List<String> allList = null;
        allList = new ArrayList<String>();
        allList.add("hello");
        allList.add(0, "world");
        allList.add("333");
//        allList.remove("hello");
//        allList.remove(0);
        String[] str = allList.toArray(new String[]{});
        Object[] obj = allList.toArray();
        for (int i = 0; i < obj.length; i ++) {
            String temp = (String)obj[i];
            System.out.print((temp == obj[i]) + " ");
        }

    }
}
