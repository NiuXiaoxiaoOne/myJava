package annotationdemo;
@Deprecated
class Demo {
    public String getInfo() {
        return "This is Person Class.";
    }
}
/**
 * @author xiaolei
 * 在类上@Deprecated的应用，可以正常执行，但会提示
 * 不建议用户使用
 */
public class DeprecatedAnnoation {
    public static void main(String[] args) {
        Demo de = new Demo();
        System.out.println(de.getInfo());
    }
}
