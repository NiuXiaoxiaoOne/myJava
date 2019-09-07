package jdbcdemo;

/**
 * @author xiaolei
 */
public class Test {
    public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName(DBDRIVER);
    }
}
