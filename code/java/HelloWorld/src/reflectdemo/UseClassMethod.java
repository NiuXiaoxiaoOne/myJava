package reflectdemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射中，调用某类的无参或有参方法
 */
public class UseClassMethod {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        Class<?> target = null;

        /* 调用无参方法 */
        // 实例化Class对象
        target = Class.forName("reflectdemo.People");
        // 找到方法
        Method met = target.getMethod("sayChina");
        // 使用方法，传入一个对象实例
        met.invoke(target.newInstance());

        /* 调用有参方法 */
        // 找到方法后要声明其参数类型
        Method met2 = target.getMethod("sayHello",
                String.class, int.class);
        // 使用方法，要输入对应的值
        String rv = null;
        rv = (String)met2.invoke(target.newInstance(), "xiaozhou", 13);
        System.out.println(rv);
    }
}
