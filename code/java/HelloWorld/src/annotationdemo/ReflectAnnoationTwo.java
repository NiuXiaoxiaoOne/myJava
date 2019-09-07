package annotationdemo;

import java.lang.annotation.*;
import java.lang.reflect.Method;

import static java.lang.annotation.RetentionPolicy.CLASS;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author xiaolei
 */
@Retention(value = RUNTIME)
@interface DefaultAnnotation {
    public String name() default "zhou";
    public String key() default "13";
}
class SimpleBeanTwo {
    @SuppressWarnings("unchecked")
    @Deprecated
    @Override
    @DefaultAnnotation
    public String toString() {
        return "h";
    }
}
/**
 * @author xiaolei
 * 查看SimpleBeanTwo中的toString()中的DefaultAnnotation注释的内容
 */
public class ReflectAnnoationTwo {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException {
        Class<?> target = null;
        target = Class.forName("annotationdemo.SimpleBeanTwo");
        Method me = target.getMethod("toString");
        // 判断toString()是否存在DefaultAnnotation
        if (me.isAnnotationPresent(DefaultAnnotation.class)) {
            DefaultAnnotation da = null;
            // 取得自定义的Annotation
            da = me.getAnnotation(DefaultAnnotation.class);
            String name = da.name();
            String key = da.key();
            // 打印Annotation以及其中的变量
            System.out.println(da + " " + name + " " + key);
        }
    }
}