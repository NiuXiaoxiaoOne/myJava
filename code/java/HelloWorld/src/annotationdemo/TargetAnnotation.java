package annotationdemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author xiaolei
 * 自定义一个Annotation, 可以指定多个范围，需要用大括号包起来
 * P572
 */
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PACKAGE})
@interface Target1 {
    public String key() default "xiaozhou";
}
/**
 * @author xiaolei
 */
public class TargetAnnotation {
    @Target1
    public String toPrint() {
        return "h";
    }
}
