package enumdemo;

/**
 * @author xiaolei
 */
class Color {
    public static final Color RED = new Color("red");
    public static final Color GREEN = new Color("green");
    public static final Color BLUE = new Color("blue");

    private String colName;
    private Color(String colName) {
        setColName(colName);
    }
    public String getColName() {
        return this.colName;
    }
    public void setColName(String colName) {
        this.colName = colName;
    }
    public static Color getInstance(int i) {
        switch (i) {
            case 1: {
                return RED;
            }
            case 2: {
                return GREEN;
            }
            case 3: {
                return BLUE;
            }
            default: {
                return null;
            }
        }
    }

}
/**
 * @author xiaolei
 */
public class BaseClass {
    public static void main(String[] args) {

    }
}
