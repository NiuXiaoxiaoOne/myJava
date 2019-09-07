package annotationdemo;

/**
 * 定义枚举，用来限定范围
 */
enum MyName {
    Red, Blue, White;
}
/**
 * @author xiaolei
 * 使用枚举来限定范围
 */
@interface MyAnnotation {
    // 设定MyName类型的默认值
    public MyName key() default MyName.Blue;
}
/**
 * @author xiaolei
 *
 * 自定义一个Annoation: MyAnnotation, 并使用它
 * 可以使用默认值或者指定枚举内的范围
 */
@MyAnnotation
public class EnumAnnoation {
    @MyAnnotation(key = MyName.Red)
    public void random() {
    }
}
//    public String Mvalue() default "hello";
//    public String Mkey() default "bing";