package annotationdemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

class SimpleBeanOne {
    @SuppressWarnings("unchecked")
    @Deprecated
    @Override
    public String toString() {
        return "hello";
    }
}
/**
 * @author xiaolei
 * 找出SimpleBeanOne类中toString()的Annoation
 * 只显示Annoation中Retention值为RUNTIME的
 */
public class ReflectAnnoationOne {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException {
        Class<?> target = null;
        // 取得SimpleBeanOne实例
        target = Class.forName("annotationdemo.SimpleBeanOne");
        // 取出toString()
        Method me = target.getMethod("toString");
        // 取出toString()的Annoation
        Annotation[] an = me.getAnnotations();
        for (Annotation i : an) {
            System.out.println(i);
        }

    }
}
