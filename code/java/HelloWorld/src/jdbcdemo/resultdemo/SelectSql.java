package jdbcdemo.resultdemo;
import java.sql.*;

/**
 * @author xiaolei
 * ResultSet查询语句的应用
 */
public class SelectSql {
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/school";
    public static final String DBUSER = "root";
    public static final String DBPASS = "123456";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT name,password,age,sex FROM user";
        Class.forName(DBDRIVER);
        conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        stmt = conn.createStatement();
        // 增加了一个executeQuery操作
        rs = stmt.executeQuery(sql);
        /**
         * 执行sql语句, .next()代表下一行
          */
        while (rs.next()) {
            // 方法1: 指定列名
//            String myName = rs.getString("name");
//            String myPassword = rs.getString("password");
//            int myAge = rs.getInt("age");
//            String mySex = rs.getString("sex");

            // 方法2: 指定索引, 推荐方法
            String myName = rs.getString(1);
            String myPassword = rs.getString(2);
            int myAge = rs.getInt(3);
            String mySex = rs.getString(4);

            System.out.print("name: " + myName + "; ");
            System.out.print("password: " + myPassword + "; ");
            System.out.print("age: " + myAge + "; ");
            System.out.print("sex: " + mySex + "\n");
            System.out.println("======");
        }

        rs.close();
        stmt.close();
        conn.close();
    }
}
