package annotationdemo;
@Deprecated
class Hash<T> {
    private T var;
    public T getVar() {
        return var;
    }
    public void setVar(T var) {
        this.var = var;
    }
}
/**
 * @author xiaolei
 * 应用@SuppressWarnings,压制警告信息
 * 可以指定压制单个或多个消息
 * P564
 */
public class SuppressWarningsAnnoation {
//    @SuppressWarnings("unchecked")
//    @SuppressWarnings(value = {"unchecked", "deprecation"})

    @SuppressWarnings({"unchecked", "deprecation"})
    public static void main(String[] args) {
        Hash ha = new Hash();
        ha.setVar("xiaozhou");
        System.out.println(ha.getVar());
    }
}
