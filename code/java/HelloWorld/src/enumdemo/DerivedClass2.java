package enumdemo;

/**
 * @author xiaolei
 * 使用setter为属性赋值
 */
enum Color2 {
    RED, GREEN, BLUE;
    private String colName;
    public String getColName() {
        return this.colName;
    }
    public void setColName(String colName) {
        switch (this) {
            case RED: {
                if ("red".equals(colName)) {
                    this.colName = colName;
                } else {
                    System.out.println("Error at switch!");
                }
                break;
            }
            case GREEN: {
                if ("green".equals(colName)) {
                    this.colName = colName;
                } else {
                    System.out.println("Error at switch!");
                }
                break;
            }
            case BLUE: {
                if ("blue".equals(colName)) {
                    this.colName = colName;
                } else {
                    System.out.println("Error at switch!");
                }
                break;
            }
        }
    }
}
public class DerivedClass2 {
    public static void main(String[] args) {
        Color2 c = Color2.valueOf(Color2.class, "BLUE");
        c.setColName("pink");
        c.setColName("blue");
        System.out.println(c.getColName());
    }
}
