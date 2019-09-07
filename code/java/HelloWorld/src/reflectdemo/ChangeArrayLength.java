package reflectdemo;

import java.lang.reflect.Array;

/**
 * 改变数组大小
 * @author xiaolei
 */
public class ChangeArrayLength {
    public static void main(String[] args) {
        int[] temp = {1, 2, 3};
        int[] newTemp = (int[])arraylnc(temp, 5);
        toPrint(newTemp);
        System.out.println("\n" + "=======");
    }
    // 将旧数组复制给新数组
    public static Object arraylnc(Object obj, int len) {
        Class<?> target = obj.getClass();
        Class<?> arr = target.getComponentType();
        Object newArray = Array.newInstance(arr, len);
        int le = Array.getLength(obj);
        // 源数组, 拷贝起始, 新数组, 拷贝起始, 源数组长度
        System.arraycopy(obj, 0, newArray, 0, le);
        return newArray;
    }
    // 打印数组
    public static void toPrint(Object obj) {
        // 通过数组得到Class对象
        Class<?> target = obj.getClass();

        if (!target.isArray()) {
            System.out.println("Entering the array is not Array!");
        }
        // 得到数组的Class对象
        Class<?> arr = target.getComponentType();
        int arrayLength =  Array.getLength(obj);
        System.out.println(arr.getName() + "length: " + arrayLength);
        for (int i = 0; i < arrayLength; i++) {
            System.out.print(Array.get(obj, i) + " ");
        }
    }
}
