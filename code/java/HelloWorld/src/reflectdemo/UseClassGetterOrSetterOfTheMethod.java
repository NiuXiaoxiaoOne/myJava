package reflectdemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author xiaolei
 * 演示反射中调用getter()和setter()方法
 */
public class UseClassGetterOrSetterOfTheMethod {
    public static void main(String[] args)
            throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, InvocationTargetException, NoSuchMethodException {
        Class<?> target = null;
        Object obj = null;
        // 实例化Class对象
        target = Class.forName("reflectdemo.People");
        // 实例化操作对象
        obj = target.newInstance();
        setter(obj, "Name", "xiaozhou", String.class);
        setter(obj, "Age", 30, int.class);
        System.out.print("userName: ");
        getter(obj, "Name");
        System.out.print("userAge: ");
        getter(obj, "Age");
    }

    /**
     * @param obj 操作的实例化对象
     * @param att 操作的属性
     * @param value 设置的值
     * @param type 参数的类型
     */
    public static void setter(Object obj, String att,
                              Object value, Class<?> type) throws
            InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        // setName() or setAge(), getMethod()设置方法中的参数类型
        Method met = obj.getClass().
                getMethod("set" + att, type);
        // 通过反射调用实例化对象obj中和met有关的方法，并输入值
        met.invoke(obj, value);
    }
    public static void getter(Object obj, String att)
            throws InvocationTargetException, IllegalAccessException,
            NoSuchMethodException {
        Method met = obj.getClass().getMethod("get" + att);
        System.out.println(met.invoke(obj));
    }
}
