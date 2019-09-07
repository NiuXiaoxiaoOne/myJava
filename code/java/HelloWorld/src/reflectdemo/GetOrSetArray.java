package reflectdemo;

import java.lang.reflect.Array;

/**
 * 取得数组信息并修改数组内容
 * @author xiaolei
 */
public class GetOrSetArray {
    public static void main(String[] args) {
        int[] temp = {1, 2, 3};
        // 取得数组的Class对象
        Class<?> target = temp.getClass().getComponentType();
        System.out.println("ArrayTypes: " + target.getName());
        System.out.println("ArrayLength: " + Array.getLength(temp));
        System.out.println("ArrayFirstElement: " + Array.get(temp, 0));
        // 修改数组内容
        Array.set(temp, 0, 6);
        System.out.println("ArrayFirstElement: " + Array.get(temp, 0));
    }
}
