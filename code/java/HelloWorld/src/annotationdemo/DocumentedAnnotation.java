package annotationdemo;

import java.lang.annotation.Documented;

/**
 * @author xiaolei
 * \@Documented的应用
 */
@Documented
@interface Documented1 {
    public String key() default "h";
}

/**
 * @author xiaolei
 */
public class DocumentedAnnotation {
    /**
     * @return 字符串
     * 此注释在方法中调用【常用】
     */
    @Documented1
    public String toPrint() {
        return "h";
    }
}
