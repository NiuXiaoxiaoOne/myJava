package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author xiaolei
 * 往school/userTables中添加一条数据
 */
public class InsertSql {
    /**
     * DBDRIVER 加载驱动程序
     * DBURL 定义数据库连接地址
     * DBUSER DBPASS 数据库用户名以及地址
     */
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/school";
    public static final String DBUSER = "root";
    public static final String DBPASS = "123456";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /**
         * conn 数据库连接
         * stmt 数据库操作
         * sql sql语句
         */
        Connection conn = null;
        Statement stmt = null;
        String myname = "lion";
        String mypassword = "55";
        int myage = 55;
        String mysex = "woman";

        String sql = "INSERT INTO user " +
                "VALUES('" + myname + "', '" + mypassword + "', " + myage + ", '" + mysex + "')";
        /**
         * forName 加载驱动
         * conn 连接指定数据库
         * stmt 实例化Statement对象
         */
        Class.forName(DBDRIVER);
        conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        stmt = conn.createStatement();
        /**
         * 更新数据库
         * 退出Statement
         * 退出Connection
         */
        stmt.executeUpdate(sql);
        stmt.close();
        conn.close();
    }
}
