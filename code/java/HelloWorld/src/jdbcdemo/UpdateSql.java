package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author xiaolei
 * 更新school/userTable中的cat数据
 */
public class UpdateSql {
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/school";
    public static final String DBUSER = "root";
    public static final String DBPASS = "123456";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;
        String myName = "cat";
        String myPassword = "00";
        int myAge = 10;
        String mySex = "man";
        String sql = "UPDATE IGNORE user " +
                "SET password = '" + myPassword + "', age = '" + myAge + "', sex = '" + mySex + "'" +
                "WHERE name = '" + myName + "'";
        Class.forName(DBDRIVER);
        conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        stmt.close();
        conn.close();
    }
}
