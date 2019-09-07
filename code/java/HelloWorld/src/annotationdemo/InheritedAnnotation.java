package annotationdemo;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author xiaolei
 * \@Inherited的应用
 */
public class InheritedAnnotation {
    public static void main(String[] args)
            throws ClassNotFoundException {
        // 打印Student类的所有注释
        Class<?> c = null;
        c = Class.forName("annotationdemo.Student");
        Annotation[] ann = c.getAnnotations();
        for (Annotation i : ann) {
            System.out.println(i);
        }
        // 输出@Inherited1中的变量内容
        if (c.isAnnotationPresent(Inherited1.class)) {
            Inherited1 ih = null;
            ih = c.getAnnotation(Inherited1.class);
            String name = ih.name();
            System.out.println(name);
        }
    }
}

/**
 * 自定义一个Annotation
 * @author xiaolei
 */
@Retention(value = RUNTIME)
@Inherited
@interface Inherited1 {
    public String name() default "h";
}
// 应用自定义的Annotation
@Inherited1
class Person {

}
// 继承含有自定义Annotation的类
class Student extends Person {
}