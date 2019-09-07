package enumdemo;

/**
 * @author xiaolei
 * 通过构造方法为属性赋值
 */
enum Color1 {
    RED("red"), GREEN("green"), BLUE("blue");
    private String colName;
    private Color1(String colName) {
        setColName(colName);
    }
    public String getColName() {
        return this.colName;
    }
    public void setColName(String colName) {
        this.colName = colName;
    }
}
/**
 * @author xiaolei
 */
public class DerivedClass1 {
    public static void main(String[] args) {
        for (Color1 c : Color1.values()) {
            System.out.println(c.ordinal()
                + " --> " + c.name()
                + "(" + c.getColName() + ")");
        }
    }
}
