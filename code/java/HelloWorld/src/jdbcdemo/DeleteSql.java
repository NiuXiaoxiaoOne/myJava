package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author xiaolei
 * 删除操作
 * String类型则是 "WHERE name = '" + myName +  "', sex = '" + mySex + "'"
 * int类型则是 "WHERE age = " + myAge + ""
 */
public class DeleteSql {
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/school";
    public static final String DBUSER = "root";
    public static final String DBPASS = "123456";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;
        int myAge = 0;
        String sql = "DELETE FROM user " +
                "WHERE age = " + myAge + "";
        Class.forName(DBDRIVER);
        conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        stmt.close();
        conn.close();
    }
}
